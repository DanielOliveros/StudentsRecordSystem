package Domain;

import java.util.List;

import Persistence.DAOModule;


public class ManageModules {
	public static Module addModule(String id, String name, int credits, String description, String idProgram){
		Module module;
		if(DAOModule.getModule(id)==null){
			module = new Module(id, name, credits, description, idProgram);
			DAOModule.createModule(module);
		}else{
			module = null;
		}
		return module;
    }
	
	public static List<Module> getAllModules(){
		return DAOModule.getAllModules();
	}
	
	public static void allocateLecturer(String lecturerID, String moduleID){
		///IMPLEMENT
	}
	
}
