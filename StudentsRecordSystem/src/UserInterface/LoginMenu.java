package UserInterface;

import java.util.Scanner;
import Domain.ManageLogin;
import Domain.User;
import mainPackage.StateI;
import mainPackage.LoggedOutState;
import mainPackage.LoggedInState;
import mainPackage.MySystem;

public class LoginMenu implements Menu{
	private static Scanner scan = new Scanner(System.in);
	public LoginMenu(){
		
	}

	public void display() {
		String id, password, role;
		StateI state;
		System.out.println("LOGIN MENU:");
		System.out.println("Please introduce your user ID: ");
		id = scan.nextLine();
		System.out.println("Please introduce your password: ");
		password = scan.nextLine();
		User user = ManageLogin.login(id, password);
		MySystem mySystem = MySystem.getSystem();
		if(user!=null){
			role = user.getClass().getSimpleName();
			System.out.println("Welcome "+user.getName()+"! You are logged as "+role+" user.");
			state = new LoggedInState(user);
		}else{
			System.out.println("Wrong credentials.");
			state = new LoggedOutState();
			//Go to loginState
		}
		mySystem.setState(state);
		mySystem.request();
	}
}
