package Domain;

import java.util.List;

import Persistence.DAOUser;

public class ManageUsers {
	
	public static User signUp(String id, String name, String password, String role){
		User user;
		if(DAOUser.getUser(id)==null){
			user = UserFactory.getUserFactory().createUser(id, name, password, role);
			DAOUser.createUser(user);
		}else{
			user = null;
		}
		return user;
    }
	
	public static ProgramStudents registerStudentIntoProgram(String programId,String studentId){
		ProgramStudents prostu;
		QCA qca;
		QPV qpv;
		double QCA = 0.00,QPV = 0;
		String awardClassification = "empty";
		int percentage = 0;
		String moduleId = null,grade = null;
		boolean result=DAOUser.checkProStu(programId,studentId);
		if(!result){
			prostu = new ProgramStudents(programId, studentId);
			qca = new QCA(Integer.parseInt(studentId),programId,QCA,awardClassification);
			DAOUser.registerStudentIntoProgram(prostu);
			DAOUser.createQCA(qca);
			qpv = new QPV(moduleId,Integer.parseInt(studentId),grade,QPV,percentage);
			DAOUser.createQPVs(qpv);
		}else{
			prostu = null;
		}
		return prostu;
	}
	
	public static List<User> getAllUsers(String option) {
		return DAOUser.getAllUsers(option);
	}

	public static List<ProgramStudents> getAllUsersByProgramID(String programID) {
		return DAOUser.getAllUsersByProgramID(programID);
	}

	public static boolean checkModuleState(String moduleId) {
		boolean result=DAOUser.checkModuleState(moduleId);
		return result;
	}

}
