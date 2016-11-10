package lecturerMenus;

import java.util.Scanner;

import UserInterface.Menu;
import adminMenus.AdminMenu;
import mailNotifyInterface.ObserverMain;

public class LecturerMenu implements Menu{
	
	private static Scanner scan = new Scanner(System.in);
	
	public LecturerMenu(){
		
	}
	
	public void display(){
		int option;
		do{
			System.out.println("LECTURER MENU");
			System.out.println("Plase, select one of the following options:\n1. Manage Allocated modules \n2. Send Emails \n3. Go back to Admin Menu");
			option = scan.nextInt();
			if(option <1 || option > 3){
				System.out.println("You have introduced an invalid option.");
			}
		}while(option < 1 || option > 3);
		Menu myMenu;
		switch(option){
			case 1://List Modules
				manageAllocatedModules();
				this.display();
			break;
			case 2://Add Module (includes allocating the module lecturer and program)
				sendMails();
				this.display();
			break;
			default://Go to Admin Menu
				myMenu = new AdminMenu();
				myMenu.display();
			break;
		}
	}

	public void manageAllocatedModules() {
		System.out.println("LECTURER MENU");
		Menu myMenu;
		myMenu = new ManageAllocatedMenu();
		myMenu.display();
	}
	
	public void sendMails() {
		System.out.println("LECTURER MENU");
		sendInformation();
	}
	
	public void sendInformation() {
		
		String message;
		
		System.out.println("OPTION SELECTED: Send Information to students");
		
		System.out.println("Please introduce the message");
		message=scan.nextLine();
		message=scan.nextLine();
		
		ObserverMain.sendMessage(message);
		
	}

}
