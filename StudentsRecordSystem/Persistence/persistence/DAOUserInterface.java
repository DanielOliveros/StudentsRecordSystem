package persistence;

import java.util.List;

import Domain.ProgramStudents;
import Domain.QCA;
import Domain.QPV;
import Domain.User;

public interface DAOUserInterface {

	Boolean createuser(User user);
	User getuser(String id);
	List<User> getallUsers(String option);
	List<ProgramStudents> getallUsersByProgramID(String programID);
	boolean registerstudentIntoProgram(ProgramStudents prostu);
	boolean checkproStu(String programId, String studentId);
	QPV createqPVs(QPV qpv);
	boolean createqCA(QCA qca);
	boolean checkmoduleState(String moduleId);
}
