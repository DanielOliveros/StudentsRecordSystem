package Domain;

import java.util.Observable;
import java.util.Observer;

public class QCA implements Observer{
	private String studentID;
	private String programID;
	private double QCA;
	private String awardClassification;

	public QCA(String studentID, String programID, double QCA, String awardClassification){
		this.studentID = studentID;
		this.programID = programID;
		this.QCA = QCA;
		this.awardClassification = awardClassification;
	}
	
	public String getStudentID() {
		return studentID;
	}
	public void setStudentID(String studentID) {
		this.studentID = studentID;
	}
	public String getProgramID() {
		return programID;
	}
	public void setProgramID(String programID) {
		this.programID = programID;
	}
	public double getQCA() {
		return QCA;
	}
	public void setQCA(double qCA) {
		QCA = qCA;
	}
	public String getAwardClassification() {
		return awardClassification;
	}
	public void setAwardClassification(String awardClassification) {
		this.awardClassification = awardClassification;
	}
	public QCA(Observable o){
        o.addObserver(this);
    }
    
	//observer pattern:observer
    @Override
    public void update(Observable o, Object arg) {
    	String result=((QPV)o).getData();
        //System.out.println("state changed��" + ((QPV)o).getData());
        ManageAllocatedModule.setQCA(result);
    }
}
