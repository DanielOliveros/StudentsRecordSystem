package Domain;


public class Program {
	private String ID;
	private int credits;
	private String name;
	private String description;
	
	public Program(String ID,int credits,String name,String description){
		this.ID = ID;
		this.credits = credits;
		this.name = name;
		this.description = description;
	}
	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public int getCredits() {
		return credits;
	}

	public void setCredits(int credits) {
		this.credits = credits;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
