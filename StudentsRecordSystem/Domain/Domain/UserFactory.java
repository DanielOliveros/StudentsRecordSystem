package Domain;

public class UserFactory {
	private static UserFactory instance = null;
	
	public static UserFactory getUserFactory(){
		if(instance == null){
			instance = new UserFactory();
		}
		return instance;
	}
	public User createUser(String id, String name, String password, String role){
		User user;
		switch(role){
			case "Admin": 
				user = new Admin(id, name, password);
			break;
			case "Lecturer": 
				user = new Lecturer(id, name, password);
			break;
			case "Student": 
				user = new Student(id, name, password);
			break;
			default:
				user = null;
		}
		return user;
	}
}
