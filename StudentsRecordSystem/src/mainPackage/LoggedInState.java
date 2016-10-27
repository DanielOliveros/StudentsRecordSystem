package mainPackage;

import Domain.User;
import UserInterface.Menu;
import adminMenus.AdminMenu;
import lecturerMenus.LecturerMenu;
import studentMenus.StudentMenu;

public class LoggedInState implements StateI{
	private User currentUser;
	public LoggedInState(User currentUser){
		this.currentUser = currentUser;
	}
	
	public void handle() {
		Menu myMenu;
		switch(currentUser.getClass().getSimpleName()){
			case "Admin":
				myMenu = new AdminMenu();
				break;
			case "Lecturer": 
				myMenu = new LecturerMenu();
				break;
			default:
				myMenu = new StudentMenu();
				break;
		}
		myMenu.display();
	}
	
	public void setCurrentUser(User currentUser){
		this.currentUser=currentUser;
	}
	public User getCurrentUser(){
		return this.currentUser;
	}
}
