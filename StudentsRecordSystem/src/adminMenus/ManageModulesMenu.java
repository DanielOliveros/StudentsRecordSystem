package adminMenus;

import java.util.List;
import java.util.Scanner;

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
			System.out.println("Please, select one of the following options:\n1. List modules \n2. Add module \n3. Go back to Admin Menu");
			option = scan.nextInt();
			if(option <1 || option > 3){
				System.out.println("You have introduced an invalid option.");
			}
		}while(option < 1 || option > 3);
		Menu myMenu;
		switch(option){
			case 1://List Modules
				listModules();
				this.display();
			break;
			case 2://Add Module (includes allocating the module lecturer and program)
				addModule();
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
}
