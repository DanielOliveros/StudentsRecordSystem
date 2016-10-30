package Domain;

public class LecturerModule {
	private String lecturerID;
	private String moduleID;
	
	public LecturerModule(String lecturerID, String moduleID){
		this.lecturerID=lecturerID;
		this.moduleID=moduleID;
		
	}
	
	public String getLecturerID(){
		return this.lecturerID;
	}
	public String getModuleID(){
		return this.moduleID;
	}
	
	public void setIdProgram(String lecturerID){
		this.lecturerID=lecturerID;
	}
	public void setName(String moduleID){
		this.moduleID=moduleID;
	}
	
}
