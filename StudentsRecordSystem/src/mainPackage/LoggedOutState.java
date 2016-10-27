package mainPackage;

import UserInterface.LoginMenu;
import UserInterface.Menu;

public class LoggedOutState implements StateI{
	public LoggedOutState(){
		
	}
	
	public void handle() {
		Menu loginMenu = new LoginMenu();
		loginMenu.display();
	}

}
