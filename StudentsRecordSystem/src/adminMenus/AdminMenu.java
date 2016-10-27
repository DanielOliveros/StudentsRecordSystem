package adminMenus;

import java.util.Scanner;

import mainPackage.LoggedOutState;
import mainPackage.MySystem;
import UserInterface.Menu;

public class AdminMenu implements Menu{
	private static Scanner scan = new Scanner(System.in);
	public AdminMenu(){
		
	}

	public void display() {
		int option;
		do{
			System.out.println("ADMIN MENU");
			System.out.println("Plase, select one of the following options:\n1. Manage Programs\n2. Manage Modules\n3. Manage Students\n4. Manage Lecturers\n5. Log out");
			option = scan.nextInt();
			if(option <1 || option > 5){
				System.out.println("You have introduced an invalid option.");
			}
		}while(option < 1 || option > 5);
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
			default:
				MySystem.getSystem().setState(new LoggedOutState());
				MySystem.getSystem().request();
			break;
		}
	}
}
