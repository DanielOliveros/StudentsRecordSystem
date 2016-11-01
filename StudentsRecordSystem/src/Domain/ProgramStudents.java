package Domain;

public class ProgramStudents {
	private String programID;
	private String studentID;
	public ProgramStudents(String programID,String studentID){
		this.programID = programID;
		this.studentID = studentID;
	}
	public String getProgramID() {
		return programID;
	}
	public void setProgramID(String programID) {
		this.programID = programID;
	}
	public String getStudentID() {
		return studentID;
	}
	public void setStudentID(String studentID) {
		this.studentID = studentID;
	}
	
}
