package Domain;

public class Module {
	private String id;
	private String name;
	private String description;
	private int credits;
	private String idProgram;
	public Module(String id, String name, int credits, String description, String idProgram){
		this.id=id;
		this.name=name;
		this.credits=credits;
		this.description=description;
		this.idProgram=idProgram;
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
