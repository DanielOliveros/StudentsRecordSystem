package Domain;

import Persistence.DAOAssignment;

public class ManageAllocatedModule{

	public static String checkState(String moduleID) {
		return DAOAssignment.checkState(moduleID);
	}

	public static Assignment addAssignment(String name, String moduleId, String description, int percentage) {
		Assignment assignment;
		if(DAOAssignment.getItem(name)==null){
			String result=DAOAssignment.checkBeforeAdd(moduleId,percentage);
			if(result=="not ready"||result=="ready"){
			assignment = new Assignment(name, moduleId, description,percentage);
			DAOAssignment.createAssignment(assignment);
			}else{
				assignment = null;
			}
		}else{
			assignment = null;
		}
		return assignment;
	}

	


}
