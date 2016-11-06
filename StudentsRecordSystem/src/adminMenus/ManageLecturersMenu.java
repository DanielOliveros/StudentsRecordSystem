package adminMenus;

import java.util.List;
import java.util.Scanner;

import Domain.ManageModules;
import Domain.ManageUsers;
import Domain.Module;
import UserInterface.Menu;
import lecturerMenus.LecturerMenu;

public class ManageLecturersMenu implements Menu{
	private static Scanner scan = new Scanner(System.in);
	public ManageLecturersMenu(){
		
	}
	public void display(){
		System.out.println("MANAGE LECTURER MENU");
	}
}
