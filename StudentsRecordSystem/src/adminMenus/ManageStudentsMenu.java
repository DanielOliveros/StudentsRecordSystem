package adminMenus;

import java.util.List;
import java.util.Scanner;

import Domain.ManageUsers;
import Domain.Program;
import Domain.ProgramStudents;
import Domain.User;
import UserInterface.Menu;

public class ManageStudentsMenu implements Menu{
	private static Scanner scan = new Scanner(System.in);
	public ManageStudentsMenu(){
				
	}
	public void display(){
		int option;
		do{
			System.out.println("MANAGE STUDENTS MENU");
			System.out.println("Please, select one of the following options:\n1. List All Students \n2. List Students of One Program \n3. Regist Student into Program \n4. Go back to Admin Menu");
			option = scan.nextInt();
			if(option <1 || option > 4){
				System.out.println("You have introduced an invalid option.");
			}
		}while(option < 1 || option > 4);
		Menu myMenu;
		switch(option){
			case 1://List All Students
				listAllStudents();
				this.display();
			break;
			case 2://List Students of One Program
				listStudentsofOneProgram();
				this.display();
			break;
			case 3://Regist Student into Program
				registStudentIntoProgram();
				this.display();
			break;
			default://Go to Admin Menu
				myMenu = new AdminMenu();
				myMenu.display();
			break;
		}
	}
	
	private void registStudentIntoProgram() {
		String programId, studentId;
		boolean error = true;
		System.out.println("OPTION SELECTED: Regist Student Into Program");
		while(error == true){
			System.out.println("Please program ID:");
			programId = scan.next();
			System.out.println("Please insert student ID:");
			studentId=scan.next();
			if(ManageUsers.registerStudentIntoProgram(programId, studentId)!= null){
				System.out.println("Register successfully.");
				error = false;
			}else{
				System.out.println("There is an error with the data introduced. Please correct them");
			}
		}
	}
	
	private void listStudentsofOneProgram() {
		String programID;
		System.out.println("Please insert programID");
		programID = scan.next();
		List<ProgramStudents> students = ManageUsers.getAllUsersByProgramID(programID);
		for(int i=0; i<students.size(); i++){
			ProgramStudents stu = students.get(i);
			System.out.println((i+1)+". Program ID:"+stu.getProgramID() +"     Student ID:"+stu.getStudentID());
		}
	}
	public void listAllStudents(){
		String option="Student";
		List<User> students = ManageUsers.getAllUsers(option);
		for(int i=0; i<students.size(); i++){
			User stu = students.get(i);
			System.out.println((i+1)+". Name:"+stu.getName()+" id-"+stu.getId());
		}
	}
}
