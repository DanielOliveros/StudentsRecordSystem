package adminMenus;

import java.util.Scanner;

import Domain.ManageUsers;
import UserInterface.Menu;
import mainPackage.LoggedOutState;
import mainPackage.MySystem;

public class AdminMenu implements Menu{
	private static Scanner scan = new Scanner(System.in);
	public AdminMenu(){
		
	}

	public void display() {
		int option;
		do{
			System.out.println("ADMIN MENU");
			System.out.println("Plase, select one of the following options:\n1. Manage Programs\n2. Manage Modules\n3. Manage Students\n4. Manage Lecturers\n5. Sign Up User\n6. Log out");
			option = scan.nextInt();
			if(option <1 || option > 6){
				System.out.println("You have introduced an invalid option.");
			}
		}while(option < 1 || option > 6);
		Menu myMenu;
		switch(option){
			case 1://Manage Programs
				myMenu = new ManageProgramsMenu();
				myMenu.display();
			break;
			case 2: 
				myMenu = new ManageModulesMenu();
				myMenu.display();
			break;
			case 3:
				myMenu = new ManageStudentsMenu();
				myMenu.display();
			break;
			case 4:
				myMenu = new ManageLecturersMenu();
				myMenu.display();
			break;
			case 5:
				signUpUser();
				myMenu = new AdminMenu();
				myMenu.display();
			break;
			default:
				MySystem.getSystem().setState(new LoggedOutState());
				MySystem.getSystem().request();
			break;
		}
	}
	public void signUpUser(){
		String name, id, pass, role;
		boolean result = false;
		while(result == false){
			System.out.println("Please introduce the user name: ");
			scan.nextLine();
			name = scan.nextLine();
			System.out.println("Please introduce the user id: ");
			id = scan.nextLine();
			System.out.println("Please introduce the user password: ");
			pass = scan.nextLine();
			System.out.println("Please introduce the user role: ");
			role = scan.nextLine();
			if(ManageUsers.signUp(id, name, pass, role)==null){
				System.out.println("There has been an error with the introduced data. Please introduce them again.");
				result = false;
			}else{
				result = true;
				System.out.println("User sucessfully added");
			}
		}
	}
}

