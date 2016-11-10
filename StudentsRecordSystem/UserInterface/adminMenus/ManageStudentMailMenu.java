package adminMenus;

import java.util.List;
import java.util.Scanner;

import Domain.ManageModules;
import Domain.Module;
import UserInterface.Menu;
import mailNotifyInterface.MailServiceClass;
import mailNotifyInterface.ObserverMain;

public class ManageStudentMailMenu implements Menu {

	private static Scanner scan = new Scanner(System.in);
	
	@Override
	public void display() {

		int option;
		do{
			System.out.println("MANAGE STUDENTS MAIL LIST");
			System.out.println("Please, select one of the following options:\n1. List Students in Mailing list \n2. Add Student to Mailing list \n3. Go back to Admin Menu");
			option = scan.nextInt();
			if(option <1 || option > 3){
				System.out.println("You have introduced an invalid option.");
			}
		}while(option < 1 || option > 3);
		Menu myMenu;
		switch(option){
			case 1://List Modules
				listStudentsInMail();
				this.display();
			break;
			case 2://Add Module (includes allocating the module lecturer and program)
				addStudentsToMail();
				this.display();
			break;
			default://Go to Admin Menu
				myMenu = new AdminMenu();
				myMenu.display();
			break;
		}
		
	}

	private void addStudentsToMail() {

			String id;
			
			System.out.println("OPTION SELECTED: Add student to mailing list ");
			
				System.out.println("Please introduce the Student ID you want to add to mailing list:");
				id=scan.nextLine();
				id=scan.nextLine();
				
				if(ObserverMain.addStudentToMailingList(id)== "good"){
					System.out.println("Student successfully added.");
					
				}else if(ObserverMain.addStudentToMailingList(id)== "Duplicate"){
					System.out.println("Student had been added to List already");
				}
				
				else if(ObserverMain.addStudentToMailingList(id)== "Invalid"){
					System.out.println("Please register the student before trying to add to mailing List");
				}
				else{
					System.err.println("Error occured");
				}
		}
	

	private void listStudentsInMail() {

		System.out.println("OPTION SELECTED: List Students in Mailing list. Mailing list:");
		List<String> studentList = ObserverMain.getAllRegisteredStudent();
		for(int i=0; i<studentList.size(); i++){
			String list = studentList.get(i);
			System.out.println(list);
		}
		
	}

}
