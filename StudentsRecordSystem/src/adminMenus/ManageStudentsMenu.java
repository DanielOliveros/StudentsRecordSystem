package adminMenus;

import java.util.Scanner;

import UserInterface.Menu;

public class ManageStudentsMenu implements Menu{
	private static Scanner scan = new Scanner(System.in);
	public ManageStudentsMenu(){
		
	}
	public void display(){
		System.out.println("MANAGE STUDENTS MENU");
	}
}
