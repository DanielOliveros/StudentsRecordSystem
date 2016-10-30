package adminMenus;

import java.util.List;
import java.util.Scanner;

import Domain.LecturerModule;
import Domain.ManageLecturerModule;
import Domain.ManageModules;
import Domain.Module;
import UserInterface.Menu;

public class ManageModulesMenu implements Menu{
	private static Scanner scan = new Scanner(System.in);
	public ManageModulesMenu(){
		
	}
	public void display(){
		int option;
		do{
			System.out.println("MANAGE MODULES MENU");
			System.out.println("Plase, select one of the following options:\n1. List modules \n2. Add module \n3. Allocate Lecturer to Module \n4. List allocated Lecturer to Module \n5. Go back to Admin Menu");
			option = scan.nextInt();
			if(option <1 || option > 5){
				System.out.println("You have introduced an invalid option.");
			}
		}while(option < 1 || option > 5);
		Menu myMenu;
		switch(option){
			case 1://List Modules
				listModules();
				this.display();
			break;
			case 2://Add Module
				addModule();
				this.display();
			break;
			case 3://Allocate lecturer to module
				addallocateLecturerToModule();
				this.display();
			break;
			case 4://List allocated lecturer to module
				listAllocateLecturerToModule();
				this.display();
			break;
			default://Go to Admin Menu
				myMenu = new AdminMenu();
				myMenu.display();
			break;
		}
	}
	public void listModules(){
		System.out.println("OPTION SELECTED: list modules. MODULES LIST:");
		List<Module> modules = ManageModules.getAllModules();
		for(int i=0; i<modules.size(); i++){
			Module mod = modules.get(i);
			System.out.println((i+1)+". "+mod.getName()+": id-"+mod.getId()+" description-"+mod.getDescription()+" credits-"+mod.getCredits()+" program"+mod.getIdProgram());
		}
	}
	public void addModule(){
		String name, id, description, programId;
		int credits;
		boolean error = true;
		System.out.println("OPTION SELECTED: add module ");
		while(error == true){
			System.out.println("Please intoduce the module name:");
			name = scan.nextLine();
			name = scan.nextLine();
			System.out.println("Please introduce the module ID:");
			id=scan.nextLine();
			System.out.println("Please introduce the module description:");
			description = scan.nextLine();
			System.out.println("Please introduce the value of the module in credits: ");
			credits = scan.nextInt();
			System.out.println("Please introduce the module's program id: ");
			programId = scan.nextLine();
			programId = scan.nextLine();
			if(ManageModules.addModule(id, name, credits, description, programId)!= null){
				System.out.println("Module successfully added.");
				error = false;
			}else{
				System.out.println("There is an error with the data introduced. Please correct them");
			}
		}
	}
	
	public static void addallocateLecturerToModule(){
		String lecturerID; String moduleID;
		
		System.out.println("OPTION SELECTED: Allocate Lecturer to module ");
		
		System.out.println("Please insert lecturer ID:");
		lecturerID = scan.nextLine();
		lecturerID = scan.nextLine();
		System.out.println("Please insert module ID:");
		moduleID=scan.nextLine();
		
		if(ManageLecturerModule.allocateLecturerToModule(lecturerID, moduleID)== true){
			System.out.println("Module successfully alocated to Lecturer.");
			
		}else{
			System.err.println("Invalid entry, you tried to assign a Lecturer or Staff that does not exist.");
		}
		
	}
	
	public void listAllocateLecturerToModule(){
		System.out.println("OPTION SELECTED: list allocated Lecturers to Modules:");
		List<LecturerModule> manageLecturerModule = ManageLecturerModule.getAlocateLectureModule();
		for(int i=0; i<manageLecturerModule.size(); i++){
			LecturerModule mod = manageLecturerModule.get(i);
			System.out.println((i+1)+". " +"Module Id - "+mod.getModuleID()+"; Lecturer Id - " + mod.getLecturerID());
		}
	}
	
}
