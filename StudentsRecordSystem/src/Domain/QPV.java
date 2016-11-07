package Domain;

import java.util.Observable;

public class QPV extends Observable {
	private String moduleID;
	private int studentID;
	private String grade;
	private double QPV;
	private int percentage;
	
	public QPV(String moduleID, int studentID, String grade, double QPV, int percentage){
		this.moduleID = moduleID;
		this.studentID = studentID;
		this.grade = grade;
		this.QPV = QPV;
		this.percentage = percentage;
	}
	
	public String getModuleID() {
		return moduleID;
	}
	public void setModuleID(String moduleID) {
		this.moduleID = moduleID;
	}
	public int getStudentID() {
		return studentID;
	}
	public void setStudentID(int studentID) {
		this.studentID = studentID;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public double getQPV() {
		return QPV;
	}
	public void setQPV(double qPV) {
		QPV = qPV;
	}
	public int getPercentage() {
		return percentage;
	}
	public void setPercentage(int percentage) {
		this.percentage = percentage;
	}
	//observer pattern:sebject
	private String data = "";
    public String getData() {
        return data;
    }

    public void setData(String data) {
        
        if(!this.data.equals(data)){
            this.data = data;
            setChanged();
        }
        notifyObservers();
    }
}
