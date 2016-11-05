package adminMenus;

import java.util.List;
import java.util.Scanner;

import Domain.ManagePrograms;
import Domain.ManageUsers;
import Domain.Program;
import Domain.User;
import UserInterface.Menu;

public class ManageUsersMenu implements Menu{
	private static Scanner scan = new Scanner(System.in);
	public ManageUsersMenu(){
		
	}
	public void display(){
		int option;
		do{
			System.out.println("MANAGE USERS MENU");
			System.out.println("Plase, select one of the following options:\n1. List users \n2. Add User\n3. Go back to Admin Menu");
			option = scan.nextInt();
			if(option <1 || option > 3){
				System.out.println("You have introduced an invalid option.");
			}
		}while(option < 1 || option > 3);
		Menu myMenu;
		switch(option){
			case 1://List Programs
				listUsers();
				this.display();
			break;
			case 2://Add Program
				addUser();
				this.display();
			break;
			default://Go to Admin Menu
				myMenu = new AdminMenu();
				myMenu.display();
			break;
		}
	}
	
	public void listUsers(){
		System.out.println("OPTION SELECTED: list users. USERS LIST:");
		List<User> users = ManageUsers.getAllUsers();
		for(int i=0; i<users.size(); i++){
			User user = users.get(i);
			System.out.println((i+1)+". "+user.getName()+": id-"+user.getId()+" role-"+user.getClass().getSimpleName());
		}
	}
	public void addUser(){
		String name, id, password, role;
		boolean error = true;
		System.out.println("OPTION SELECTED: add user ");
		while(error == true){
			System.out.println("Please intoduce the user role:");
			role = scan.nextLine();
			role = scan.nextLine();
			System.out.println("Please intoduce the user name:");
			name = scan.nextLine();
			System.out.println("Please introduce the user ID:");
			id=scan.nextLine();
			System.out.println("Please introduce the user password:");
			password = scan.nextLine();
			if(ManageUsers.signUp(id, name, password, role)!= null){
				System.out.println("Program successfully added.");
				error = false;
			}else{
				System.out.println("There is an error with the data introduced. Please correct them");
			}
		}
	}
}
