package lecturerMenus;

import java.util.Scanner;

import UserInterface.Menu;
import adminMenus.ManageLecturersMenu;
import adminMenus.ManageModulesMenu;
import adminMenus.ManageProgramsMenu;
import adminMenus.ManageStudentsMenu;
import mainPackage.LoggedOutState;
import mainPackage.MySystem;

public class LecturerMenu implements Menu{
	private static Scanner scan = new Scanner(System.in);
	public LecturerMenu(){
		
	}

	public void display() {
		System.out.println("LECTURER MENU");
		System.out.println("Please select the module to manage");
		//List<Module> modules = ManageAllocatedModules.getCurrentUserModules()
		//for(int i=0; i<modules.size(); i++){ print module details}
		System.out.println("Insert the id of one of the modules above");
		//int id=scan.nextInt();
		//managemodule(id);
	}
	public void manageModule(String id){
		System.out.prinln("Module management: ...");
		Module module = ManageModule.getModule(id);
		if(module.ready==false){
			setAssessmentModel(module);
		}else{
			assessModule(module); //QPV subject and QCA observer.
		}
	}
}
