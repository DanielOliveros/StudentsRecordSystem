package persistence;

import java.util.List;

import Domain.Program;

public interface DAOProgramInterface {
	
	Boolean createprogram(Program program);
	Program getprogram(String id);
	List<Program> getallPrograms();
	boolean getqCA(String programId, String studentId);

}
