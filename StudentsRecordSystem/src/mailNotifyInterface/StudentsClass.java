package mailNotifyInterface;

public class StudentsClass implements StudentObserver {

	private MailService mailService;
	private String studentId;
	
	@Override
	public void update(String mailInformation, String lecturerId) {

		System.out.println("Hello " + studentId + ", there is a mail from " + lecturerId + ": " + mailInformation);
		
	}
	
	public MailService getMailService(){
		return this.mailService;
	}
	public String getStudentId(){
		return this.studentId;
	}
	
	public void setMailService(MailService mailService){
		this.mailService=mailService;
	}
	public void setStudentId(String studentId){
		this.studentId=studentId;
	}
	
	
}
