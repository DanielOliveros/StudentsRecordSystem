package adminMenus;

import java.util.List;
import java.util.Scanner;

import Domain.ManagePrograms;
import Domain.Program;
import UserInterface.Menu;

public class ManageProgramsMenu implements Menu{
	private static Scanner scan = new Scanner(System.in);
	public ManageProgramsMenu(){
		
	}
	
	public void display(){
		int option;
		do{
			System.out.println("MANAGE PROGRAMS MENU");
			System.out.println("Plase, select one of the following options:\n1. List programs \n2. Add Program\n3. Go back to Admin Menu");
			option = scan.nextInt();
			if(option <1 || option > 3){
				System.out.println("You have introduced an invalid option.");
			}
		}while(option < 1 || option > 3);
		Menu myMenu;
		switch(option){
			case 1://List Programs
				listPrograms();
				this.display();
			break;
			case 2://Add Program
				addProgram();
				this.display();
			break;
			default://Go to Admin Menu
				myMenu = new AdminMenu();
				myMenu.display();
			break;
		}
	}
	
	public void listPrograms(){
		System.out.println("OPTION SELECTED: list programs. PROGRAMS LIST:");
		List<Program> programs = ManagePrograms.getAllPrograms();
		for(int i=0; i<programs.size(); i++){
			Program prog = programs.get(i);
			System.out.println((i+1)+". "+prog.getName()+": id-"+prog.getId()+" description-"+prog.getDescription()+" credits-"+prog.getCredits());
		}
	}
	public void addProgram(){
		String name, id, description;
		int credits;
		boolean error = true;
		System.out.println("OPTION SELECTED: add program ");
		while(error == true){
			System.out.println("Please intoduce the program name:");
			name = scan.nextLine();
			name = scan.nextLine();
			System.out.println("Please introduce the program ID:");
			id=scan.nextLine();
			System.out.println("Please introduce the program description:");
			description = scan.nextLine();
			System.out.println("Please introduce the value of the program in credits: ");
			credits = scan.nextInt();
			if(ManagePrograms.addProgram(id, name, credits, description)!= null){
				System.out.println("Program successfully added.");
				error = false;
			}else{
				System.out.println("There is an error with the data introduced. Please correct them");
			}
		}
	}
}
