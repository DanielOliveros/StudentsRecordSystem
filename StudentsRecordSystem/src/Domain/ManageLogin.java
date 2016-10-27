package Domain;

import Persistence.DAOUser;


public class ManageLogin {
	public static User login(String id, String password){
		User user = DAOUser.getUser(id);
		if(user != null && user.getPassword().equals(password)){
			return user;
		}else{
			return null;
		}
	}
}
