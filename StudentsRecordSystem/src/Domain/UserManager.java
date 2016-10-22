package Domain;

import java.util.Scanner;

import Persistence.DAOUser;


public class UserManager {
	private static UserManager instance = null;
	Scanner scan = new Scanner(System.in);
	private User currentUser;
	public static UserManager getUserManager(){
		if(instance == null){
			instance = new UserManager();
		}
		return instance;
	}
	public User newUser (String id, String name, String password, String role){
		User user;
		if(DAOUser.getUser(id)==null){
			user = UserFactory.getUserFactory().createUser(id, name, password, role);
			DAOUser.createUser(user);
		}else{
			user = null;
		}
		return user;
	}
	public User login(){
		String id, password;
		System.out.println("Please introduce your user ID: ");
		id = scan.nextLine();
		System.out.println("Please introduce your password: ");
		password = scan.nextLine();
		User user = DAOUser.getUser(id);
		if(user != null && user.getPassword().equals(password)){
			System.out.println("Welcome! You are logged as a "+user.getClass().getSimpleName());
			currentUser = user;
			return currentUser;
		}else{
			System.out.println("Wrong credentials.");
			return null;
		}
	}
}
