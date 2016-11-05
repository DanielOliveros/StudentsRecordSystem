package lecturerMenus;

import java.util.Scanner;

import Domain.Module;
import UserInterface.Menu;

public class LecturerMenu implements Menu{
	private static Scanner scan = new Scanner(System.in);
	public LecturerMenu(){
		
	}

	public void display() {
		System.out.println("LECTURER MENU");
		System.out.println("Please select one of your modules:" );
		//select one of the modules and invoke getModule(moduleSelected)
		//manageModule(module)
	}
	public void manageModule(Module module){
		System.out.println("MODULE MANAGEMENT METHOD");
		System.out.println("Please select one of the following options:\n1. Set assessment model\n2. Assess Students");
		//if opti0no 1 ->> setAssessmentModel(module);
		//if option 2 -->assess students(module);
	}
	public void setAssessmentModel(Module module){
		int nassignments, percentage;
		String name, description;
		System.out.println("Please introduce the number of assignments: ");
		nassignments = scan.nextInt();
		scan.nextLine();
		for(int i = 0; i<nassignments; i++){
			System.out.println("Please introduce the name of the assignment");
			name = scan.nextLine();
			System.out.println("Please introduce the description of the assignment "+(i+1));
			description = scan.nextLine();
			System.out.println("Please introduce the value (%) of the assignment");
			percentage = scan.nextInt();
		}
	}
}
