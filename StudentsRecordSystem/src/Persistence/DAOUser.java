package Persistence;

public class DAOUser {
	public User newUser(User user){
		//user.id, user.password, user.role
		//write in the User file. For example: 1234,password,Lecturer(one line)
	}
	public User getUser(String id, String password){
		User user;
		
		//read file 
		//else if the user is an Admin: user = new Admin (idread, passread, admin)
		//else if lecturer: user = new Lecturer(...)
		//else if student: user = new Student(...)
		
		return user;
	}
}
