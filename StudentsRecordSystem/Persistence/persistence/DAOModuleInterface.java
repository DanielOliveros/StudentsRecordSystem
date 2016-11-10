package persistence;

import java.util.List;

import Domain.Module;

public interface DAOModuleInterface {

	Boolean createmodule(Module module);
	Module getmodule(String id);
	List<Module> getallModules();
	
}
