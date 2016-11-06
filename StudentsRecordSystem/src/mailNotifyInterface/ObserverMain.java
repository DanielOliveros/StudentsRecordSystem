package mailNotifyInterface;

import java.util.List;

import Domain.Student;
import Persistence.DAOMail;
import UserInterface.LoginMenu;

public class ObserverMain {

	static List<String> studentList;
	static String lecturerId = LoginMenu.getUsaId(); 
	
	public static void sendMessage(String message){
		
		getAllRegisteredStudent();
		
		MailServiceClass mailServiceClass = new MailServiceClass();
		
		String id = null;String name = null;String password = null;
		mailServiceClass.setLecturerId(lecturerId);
		mailServiceClass.setLecturerInformation(message);
		
		Student studentsClass;
		
		for(String tempStudents : studentList){
			
			studentsClass = new Student(id, name, password);
			
			studentsClass.setStudentId(tempStudents);
			mailServiceClass.registerStudent(studentsClass);
		}
		
		
		mailServiceClass.setNewMailAvailable(true);
		
	}
	
	
	public static List<String> getAllRegisteredStudent() {
		studentList = DAOMail.getAllRegisteredStudent();
		return studentList;
	}
	
	public static String addStudentToMailingList(String id) {

		if (DAOMail.getRegisteredStudent(id) == "Duplicate"){
			return "Duplicate";
		}else if (DAOMail.checkStudentId(id) == "Invalid"){
			return "Invalid";
		}else if (DAOMail.addStudentToMailList(id) != true){
			return "error occured";
		}
		return "good";
		
	}
	
	
}
