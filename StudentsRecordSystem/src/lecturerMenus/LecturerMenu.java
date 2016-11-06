package lecturerMenus;

import java.util.Scanner;

import UserInterface.Menu;
import mailNotifyInterface.ObserverMain;

public class LecturerMenu implements Menu{
	private static Scanner scan = new Scanner(System.in);
	public LecturerMenu(){
		
	}

	public void display() {
		System.out.println("LECTURER MENU");
		sendInformation();
	}
	
	public void sendInformation() {
		
		String message;
		
		System.out.println("OPTION SELECTED: Send Information to students");
		
		System.out.println("Please introduce the message");
		message=scan.nextLine();
		
		ObserverMain.sendMessage(message);
		
	}

	
}
