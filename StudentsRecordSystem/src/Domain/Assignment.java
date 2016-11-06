package Domain;


public class Assignment {
	private String name;
	private String moduleId;
	private String description;
	private int percentage;
	
	public Assignment(String name, String moduleId,String description, int percentage){
		this.name = name;
		this.moduleId = moduleId;
		this.description = description;
		this.percentage = percentage;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getModuleId() {
		return moduleId;
	}

	public void setModuleId(String moduleId) {
		this.moduleId = moduleId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getPercentage() {
		return percentage;
	}

	public void setPercentage(int percentage) {
		this.percentage = percentage;
	}
	
}
