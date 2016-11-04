package mailNotifyInterface;

import java.util.List;

import Persistence.DAOMail;
import UserInterface.LoginMenu;

public class ObserverMain {

	static List<String> studentList;
	static String lecturerId = LoginMenu.getUsaId(); 
	
	public static void sendMessage(String message){
		
		getAllRegisteredStudent();
		
		MailServiceClass mailServiceClass = new MailServiceClass();
		
		for(String tempStudents : studentList){
			
			StudentsClass studentsClass = new StudentsClass();
			
			studentsClass.setStudentId(tempStudents);
			mailServiceClass.setLecturerId(lecturerId);
			mailServiceClass.setLecturerInformation(message);
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
