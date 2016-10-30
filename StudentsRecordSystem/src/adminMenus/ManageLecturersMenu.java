package adminMenus;

import java.util.List;
import java.util.Scanner;

import Domain.Lecturer;
import Domain.ManageLecturer;
import UserInterface.Menu;

public class ManageLecturersMenu implements Menu{
	private static Scanner scan = new Scanner(System.in);
	public ManageLecturersMenu(){
		
	}
	public void display(){
		int option;
		do{
			System.out.println("MANAGE LECTURERS MENU");
			System.out.println("Plase, select one of the following options:\n1. List Lecturers \n2. Add Lecturer \n3. Go back to Admin Menu");
			option = scan.nextInt();
			if(option <1 || option > 3){
				System.out.println("You have introduced an invalid option.");
			}
		}while(option < 1 || option > 3);
		Menu myMenu;
		switch(option){
			case 1://List Lecturers
				listLecturers();
				this.display();
			break;
			case 2://Add Lecturers
				addLecturers();
				this.display();
			break;
			default://Go to Admin Menu
				myMenu = new AdminMenu();
				myMenu.display();
			break;
		}
	}
	public void listLecturers(){
		System.out.println("OPTION SELECTED: list listLecturers. LECTURERS LIST:");
		List<Lecturer> lecturers = ManageLecturer.getAllLecturers();
		for(int i=0; i<lecturers.size(); i++){
			Lecturer lecture = lecturers.get(i);
			System.out.println((i+1)+". "+lecture.getAssignedName()+": id-"+lecture.getAssignedId()+" position-"+lecture.getAssignedPosition()+" department-"+lecture.getAssignedDepartment());
		}
	}
	public void addLecturers(){
		
		String assignedId;
		String assignedName;
		String assignedPassword;
		String assignedPosition;
		String assignedDepartment;
		
		boolean error = true;
		System.out.println("OPTION SELECTED: add Lecturer ");
		while(error == true){
			
			System.out.println("Please intoduce the Lecturer name:");
			assignedName = scan.nextLine();
			assignedName = scan.nextLine();
			
			System.out.println("Please introduce the Leturer ID:");
			assignedId=scan.nextLine();
			
			System.out.println("Please introduce the Lecturer password:");
			assignedPassword = scan.nextLine();
			
			System.out.println("Please introduce the Lecturer Position: ");
			assignedPosition = scan.nextLine();
			
			System.out.println("Please introduce the Lecturer's department: ");
			assignedDepartment = scan.nextLine();
			
			if(ManageLecturer.addLecturer(assignedId, assignedName, assignedPassword, assignedPosition, assignedDepartment)!= null){
				System.out.println("Lecturer successfully added.");
				error = false;
			}else{
				System.out.println("There is an error with the data introduced. Please correct them");
			}
		}
	}
	
	
}
