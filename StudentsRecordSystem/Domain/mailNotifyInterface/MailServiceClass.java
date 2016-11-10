package mailNotifyInterface;

import java.util.List;

import java.util.ArrayList;

public class MailServiceClass implements MailService{
	
	private List<StudentObserver> listOfStudentObserver = new ArrayList<StudentObserver>();
	private String lecturerId;
	private String lecturerInformation;
	private boolean mailAvailable = false;
	
	public String getLecturerId(){
		return this.lecturerId;
	}
	public String getLecturerInformation(){
		return this.lecturerInformation;
	}
	public List<StudentObserver> getListOfStudentObserver(){
		return this.listOfStudentObserver;
	}
	public boolean getMailAvailable(){
		return this.mailAvailable;
	}
	
	public void setListOfStudentObserver(List<StudentObserver> listOfStudentObserver){
		this.listOfStudentObserver=listOfStudentObserver;
	}
	public void setLecturerId(String lecturerId){
		this.lecturerId=lecturerId;
	}
	public void setLecturerInformation(String lecturerInformation){
		this.lecturerInformation=lecturerInformation;
	}
	public void setNewMailAvailable(boolean mailAvailable){
		this.mailAvailable=mailAvailable;
		
		if(mailAvailable == true){
			notifyStudents();
		}
	}
	

	@Override
	public void registerStudent(StudentObserver studentObserver) {

		listOfStudentObserver.add(studentObserver);
		
	}

	@Override
	public void unRegisterStudent(StudentObserver studentObserver) {

		listOfStudentObserver.remove(studentObserver);
		
	}

	@Override
	public void notifyStudents() {
		
		System.out.println("");
		System.out.println("NOTIFYING OBSERVER");
		System.out.println("Note that this is not in a Menu class because it is a notification, the print is only illustrating");
		System.out.println("");
		
		for (StudentObserver studentObserver : listOfStudentObserver){
			studentObserver.update(lecturerInformation, lecturerId);
		}
		
	}
	
}
