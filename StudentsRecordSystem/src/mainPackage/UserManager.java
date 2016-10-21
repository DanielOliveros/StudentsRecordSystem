package mainPackage;

public class UserManager {
	private static UserManager instance = null;
	private User currentUser;
	
	
	public static UserManager getInstance(){
		if(instance == null){
			instance = new UserManager();
		}
		return instance;
	}
	
	
	public User signUp (String id, String password, String role){
		return userFactory.createUser(id, password, role);
	}
	
	public boolean login(String id, String password){
		try{
			currentUser=DAOUsers.getUser(id, password);
			return true;
		}catch(Exception e){
			System.out.println("Error at login");
			currentUser=null;
			return false;
		}
	}
}
