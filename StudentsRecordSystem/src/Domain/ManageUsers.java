package Domain;



import java.util.List;

import Persistence.DAOUser;

public class ManageUsers {
	public static User signUp(String id, String name, String password, String role){
		User user;
		if(DAOUser.getUser(id)==null){
			user = UserFactory.getUserFactory().createUser(id, name, password, role);
			DAOUser.createUser(user);
		}else{
			user = null;
		}
		return user;
    }
	public static void registerStudentIntoProgram(String studentId, String programId){
		//
	}
	public static List<User> getAllUsers(){
		return DAOUser.getAllUsers();
	}
}
