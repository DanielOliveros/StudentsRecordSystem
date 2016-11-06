package lecturerMenus;

import java.util.List;
import java.util.Scanner;

import Domain.Assignment;
import Domain.ManageAllocatedModule;
import Domain.ManageUsers;
import Domain.Module;
import UserInterface.Menu;

public class ManageAllocatedMenu implements Menu {
	private static Scanner scan = new Scanner(System.in);
	public ManageAllocatedMenu(){
		
	}
	@Override
	public void display() {
		int option;
		System.out.println("Please input your ID:");
		String lecturerID = scan.next();
		listUserModules(lecturerID);
		System.out.println("Please insert module ID:");
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
		System.out.println("Please insert student ID:");
		String studentID = scan.next();
		setGrade(studentID,moduleID);
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
