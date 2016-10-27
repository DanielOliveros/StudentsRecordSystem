package adminMenus;

import java.util.Scanner;

import UserInterface.Menu;

public class ManageLecturersMenu implements Menu{
	private static Scanner scan = new Scanner(System.in);
	public ManageLecturersMenu(){
		
	}
	public void display(){
		System.out.println("MANAGE LECTURERS MENU");
	}
}
