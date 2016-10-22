package Domain;
import java.util.Scanner;

public class Admin extends User{
 
    private Scanner scan;
	public Admin(String id, String name, String password){
		super(id, name, password);
	}
    public User signUp(){
    	scan = new Scanner(System.in);
    	String id, name, password, role;
    	System.out.println("Please select the role of the new user:\n1.Admin\n2.Lecturer\n3.Student");
    	switch(scan.nextInt()){
    	case 1: 
    		role = "Admin";
    		break;
    	case 2: 
    		role = "Lecturer";
    		break;
    	default:
    		role = "Student";
    		break;
    	}
    	System.out.println("Please insert the user name: ");
    	name = scan.nextLine();
    	name = scan.nextLine();
    	System.out.println("Please insert the user id: ");
    	id = scan.nextLine();
    	System.out.println("Please insert the user password: ");
    	password = scan.nextLine();
    	//ask for data in this method.
    	return UserManager.getUserManager().newUser(id, name, password, role);
    }
}
