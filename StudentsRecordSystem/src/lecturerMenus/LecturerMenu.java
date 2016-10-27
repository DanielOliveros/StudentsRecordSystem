package lecturerMenus;

import java.util.Scanner;

import UserInterface.Menu;

public class LecturerMenu implements Menu{
	private static Scanner scan = new Scanner(System.in);
	public LecturerMenu(){
		
	}

	public void display() {
		System.out.println("LECTURER MENU");
	}
}
