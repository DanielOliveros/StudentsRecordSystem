package lecturerMenus;

import java.util.Scanner;

import Domain.ManageAllocatedModule;
import Domain.ManagePrograms;
import UserInterface.Menu;

public class ManageAllocatedMenu implements Menu {
	private static Scanner scan = new Scanner(System.in);
	public ManageAllocatedMenu(){
		
	}
	@Override
	public void display() {
		int option;
		//根据用户ID查课程 尚未实现，函数要重新写，这个函数不对
		//System.out.println("Please input ModuleID/ModuleName:");
		//String lecturerID = scan.next();
		//listModules();
		//this.display();
		System.out.println("Please insert module ID:");
		String moduleID = scan.next();
		if(checkState(moduleID)){
			System.out.println("this is ready");
		}else{
				System.out.println("The assignment in "+moduleID+"is less than 100,please finish it first:");
                do{
                	addAssignment(moduleID);				
                }while(!checkState(moduleID));
                System.out.println("退出循环了");
		}
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
	public void listUserModules(){
		
	}

}
