package Domain;

import Persistence.DAOUser;


public class ManageLogin {
	private static ManageLogin instance = null;
	private User currentUser;
	public static ManageLogin getManageLogin(){
		if(instance == null){
			instance = new ManageLogin();
		}
		return instance;
	}
		
	public User login(String id, String password){
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
