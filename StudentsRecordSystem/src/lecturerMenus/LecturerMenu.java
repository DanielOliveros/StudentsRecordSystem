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
	}
}
