package UserInterface;

import java.util.Scanner;
import Domain.ManageLogin;
import Domain.ManageThreads;
import Domain.User;
import mainPackage.StateI;
import mainPackage.LoggedOutState;
import mainPackage.LoggedInState;
import mainPackage.MySystem;

public class LoginMenu extends Thread implements Menu{
	private static Scanner scan = new Scanner(System.in);
	public LoginMenu(){
		
	}
	
	static String id;
	static String password;
	static String role;
	static StateI state;
	static MySystem mySystem = MySystem.getSystem();
	static User user;
	
	public void display() {
		System.out.println("LOGIN MENU:");
		System.out.println("Please introduce your user ID: ");
		setUsaId(scan.nextLine());
		System.out.println("Please introduce your password: ");
		password = scan.nextLine();
		user = ManageLogin.login(getUsaId(), password);
		
		if(user!=null){
			role = user.getClass().getSimpleName();
			System.out.println("Welcome "+user.getName()+"! You are logged as "+role+" user.");
			state = new LoggedInState(user);
			
			LoginMenu timerThread = new LoginMenu();
			timerThread.start();
			
		}else{
			System.out.println("Wrong credentials.");
			state = new LoggedOutState();
			//Go to loginState
		}
		mySystem.setState(state);
		mySystem.request();
	}
	
	public void run(){
		
		ManageThreads manageTimer = new ManageThreads();
		manageTimer.countDown();
	}

	public static void expirationWarninig() {
		
		System.err.println("Please note that your session will expire in 1 minute");
		
	}
	
	public static void expirationAction() {
		
		
		System.err.println("Sorry, your session has expired and you have been logged out, please log in again");
		
		state = new LoggedOutState();
		mySystem.setState(state);
		mySystem.request();
		
	}

	public static String getUsaId() {
		return id;
	}

	public static void setUsaId(String id) {
		LoginMenu.id = id;
	}
	
}
