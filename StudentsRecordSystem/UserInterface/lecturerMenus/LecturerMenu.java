package lecturerMenus;

import UserInterface.Menu;

public class LecturerMenu implements Menu{
	public LecturerMenu(){
		
	}

	public void display() {
		System.out.println("LECTURER MENU");
		Menu myMenu;
		myMenu = new ManageAllocatedMenu();
		myMenu.display();
	}
}
