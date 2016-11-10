package mailNotifyInterface;

public interface MailService {

	public void registerStudent(StudentObserver studentObserver);
	public void unRegisterStudent(StudentObserver studentObserver);
	public void notifyStudents();
	
}
