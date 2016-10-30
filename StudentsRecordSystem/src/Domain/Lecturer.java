package Domain;


public class Lecturer extends User {

	public Lecturer(String id,String name,String password){
		super(id, name, password);	
	}
	
	private String assignedId;
	private String assignedName;
	private String assignedPassword;
	private String assignedPosition;
	private String assignedDepartment;
	
	public Lecturer(String assignedId, String assignedName, String assignedPassword, String assignedPosition, String assignedDepartment){
		
		super(null, null, null);
		
		this.assignedId=assignedId;
		this.assignedName=assignedName;
		this.assignedPassword=assignedPassword;
		this.assignedPosition=assignedPosition;
		this.assignedDepartment=assignedDepartment;
	}
	
	public String getAssignedId(){
		return this.assignedId;
	}
	public String getAssignedName(){
		return this.assignedName;
	}
	public String getAssignedPassword(){
		return this.assignedPassword;
	}
	public String getAssignedPosition(){
		return this.assignedPosition;
	}
	public String getAssignedDepartment(){
		return this.assignedDepartment;
	}
	public void setAssignedId(String assignedId){
		this.assignedId=assignedId;
	}
	public void setAssignedName(String assignedName){
		this.assignedName=assignedName;
	}
	public void setAssignedPosition(String assignedPosition){
		this.assignedPosition=assignedPosition;
	}
	public void setAssignedPassword(String assignedPassword){
		this.assignedPassword=assignedPassword;
	}
	public void setAssignedDepartment(String assignedDepartment){
		this.assignedDepartment=assignedDepartment;
	}
	
}
