package Domain;

public class Assignment {
	private String description;
	private int percentage;
	private String name;
	public Assignment(String name, String description, int percentage){
		this.name=name;
		this.description=description;
		this.percentage=percentage;
	}
	public String getName(){
		return this.name;
	}
	public String getDescription(){
		return this.description;
	}
	public int getPercentage(){
		return this.getPercentage();
	}
	public void setName(String name){
		this.name=name;
	}
	public void setDescription(String description){
		this.description=description;
	}
	public void setPercentage(int percentage){
		this.percentage=percentage;
	}
}
