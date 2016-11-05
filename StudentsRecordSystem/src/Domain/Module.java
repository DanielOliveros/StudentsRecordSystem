package Domain;

import java.util.ArrayList;
import java.util.List;

public class Module {
	private String id;
	private String name;
	private String description;
	private int credits;
	private String idProgram;
	private String idLecturer;
	private List<Assignment> assignments = new ArrayList();
	public Module(String id, String name, int credits, String description, String idProgram, String idLecturer){
		this.id=id;
		this.name=name;
		this.credits=credits;
		this.description=description;
		this.idProgram=idProgram;
		this.idLecturer = idLecturer;
	}
	public boolean addAssignment(String asName, String asDescription, int asPercentage){
		if(checkValidPercentage(asPercentage)){
			this.assignments.add(new Assignment(asName, asDescription, asPercentage));
			return true;
		}
		return false;
	}
	public boolean checkValidPercentage(int asPercentage){
		int globalPercentage = asPercentage;
		for(int i=0; i<assignments.size(); i++){
			globalPercentage = globalPercentage + assignments.get(i).getPercentage();
		}
		if(globalPercentage>100){
			return false;
		}
		return true;
	}
	public String getIdLecturer(){
		return this.idLecturer;
	}
	public void setIdLecturer(String idLecturer){
		this.idLecturer=idLecturer;
	}
	public String getIdProgram(){
		return this.idProgram;
	}
	public String getName(){
		return this.name;
	}
	public String getId(){
		return this.id;
	}
	public String getDescription(){
		return this.description;
	}
	public int getCredits(){
		return this.credits;
	}
	public void setIdProgram(String idProgram){
		this.idProgram=idProgram;
	}
	public void setName(String name){
		this.name=name;
	}
	public void setId(String id){
		this.id=id;
	}
	public void setDescription(String description){
		this.description=description;
	}
	public void setCredits(int credits){
		this.credits=credits;
	}
}
