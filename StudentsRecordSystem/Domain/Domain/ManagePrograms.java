package Domain;


import java.util.List;

import persistence.DAOProgram;
import persistence.DAOUser;

public class ManagePrograms {
	
	public static Program addProgram(String id, String name, int credits, String description){
		Program program;
		if(DAOProgram.getProgram(id)==null){
			program = new Program(id, name, credits, description);
			DAOProgram.createProgram(program);
		}else{
			program = null;
		}
		return program;
    }
	
	public static List<Program> getAllPrograms(){
		return DAOProgram.getAllPrograms();
	}
}
