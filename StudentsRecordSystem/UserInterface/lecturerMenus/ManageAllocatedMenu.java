package lecturerMenus;

import java.util.List;
import java.util.Scanner;

import Domain.Assignment;
import Domain.Lecturer;
import Domain.ManageAllocatedModule;
import Domain.ManageUsers;
import Domain.Module;
import Domain.ProgramStudents;
import UserInterface.Menu;
import mainPackage.LoggedInState;
import mainPackage.MySystem;
import persistence.DAOModule;

public class ManageAllocatedMenu implements Menu {
	private static Scanner scan = new Scanner(System.in);
	public ManageAllocatedMenu(){
		
	}
	@Override
	public void display() {
		int option;
		
		LoggedInState currentState = (LoggedInState) MySystem.getSystem().getState();
		Lecturer lecturer = (Lecturer) currentState.getCurrentUser();//scan.next();
		System.out.println("Lecturer logged in: "+lecturer.getName());
		System.out.println("Allocated modules list:" );
		listUserModules(lecturer.getId());
		System.out.println("Please insert one module ID:");
		String moduleID = scan.next();
		if(checkState(moduleID)){
			listModuleAssessment(moduleID);
		}else{
				System.out.println("The assignment in "+moduleID+"is less than 100,please finish it first:");
                do{
                	addAssignment(moduleID);				
                }while(!checkState(moduleID));
                listModuleAssessment(moduleID);
		}
		System.out.println("The module is ready to start assessing students. ");
		System.out.println("Please insert student ID of this module:");
		listProgramStudents(moduleID);
		String studentID = scan.next();
		setGrade(studentID,moduleID);
	}
	
	public void listProgramStudents(String moduleID){
		Module module = DAOModule.getModule(moduleID);
		String programID = module.getIdProgram();
		List<ProgramStudents> students = ManageUsers.getAllUsersByProgramID(programID);
		for(int i=0; i<students.size(); i++){
			ProgramStudents stu = students.get(i);
			System.out.println((i+1)+". Program ID:"+stu.getProgramID() +"     Student ID:"+stu.getStudentID());
		}
	}
	
	
	private void setGrade(String studentID, String moduleID) {
		ManageAllocatedModule.setGrade(studentID,moduleID);
	}
	private void addAssignment(String moduleId) {
		String name,description;
		int percentage;
		boolean error = true;
		while(error == true){
			System.out.println("Please intoduce the assignment name of "+moduleId+" :");
			name = scan.nextLine();
			name = scan.nextLine();
			System.out.println("Please introduce the assignment description:");
			description = scan.nextLine();
			System.out.println("Please introduce the percentage of this assignment: ");
			percentage = scan.nextInt();
			if(ManageAllocatedModule.addAssignment(name,moduleId,description,percentage)!= null){
				System.out.println("Assignment successfully added.");
				error = false;
			}else{
				System.out.println("There is an error with the data introduced. Please correct them");
			}
		}
		
	}
	private boolean checkState(String moduleID) {
		boolean error = true;
		String result=ManageAllocatedModule.checkState(moduleID);
		if(result=="ready"){
			error=true;
		}else {
			error=false;
		}
		return error;
	}
	public void listUserModules(String lecturerID){
		List<Module> modules = ManageAllocatedModule.getUserModule(lecturerID);
		for(int i=0; i<modules.size(); i++){
			Module module = modules.get(i);
			System.out.println((i+1)+". Module ID:"+module.getId());
		}
	}

	private void listModuleAssessment(String moduleID) {
		List<Assignment> assignment = ManageAllocatedModule.getModuleAssignment(moduleID);
		for(int i=0; i<assignment.size(); i++){
			Assignment ass = assignment.get(i);
			System.out.println((i+1)+". Module ID:"+ass.getModuleId()+". Assessignment Name:"+ass.getName()+". Assessignment Percentage:"+ass.getPercentage());
		}
	}

}
