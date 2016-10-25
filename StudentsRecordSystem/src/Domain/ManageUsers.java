package Domain;



import Persistence.DAOUser;

public class ManageUsers {
	private static ManageUsers instance = null;
	public static ManageUsers getManageUsers(){
		if(instance == null){
			instance = new ManageUsers();
		}
		return instance;
	}
	
	public User signUp(String id, String name, String password, String role){
		User user;
		if(DAOUser.getUser(id)==null){
			user = UserFactory.getUserFactory().createUser(id, name, password, role);
			DAOUser.createUser(user);
		}else{
			user = null;
		}
		return user;
    }
}
