package Domain;

public class Program {
	private String id;
	private int credits;
	private String name;
	private String description;
	
	public Program(String id, String name, int credits, String description){
		this.id = id;
		this.credits = credits;
		this.name = name;
		this.description = description;
	}
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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
