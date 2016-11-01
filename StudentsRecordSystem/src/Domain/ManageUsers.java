package Domain;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import Persistence.DAOModule;
import Persistence.DAOProgram;
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
		boolean result=DAOUser.checkProStu(programId,studentId);
		if(!result){
			prostu = new ProgramStudents(programId, studentId);
			DAOUser.registerStudentIntoProgram(prostu);
			//createQCA(studentId,programId);
			//createQPVs(studentId,programId);
		}else{
			prostu = null;
		}
		return prostu;
	}

	//createQCA
	//createQPVs
	
	public static List<User> getAllUsers(String option) {
		return DAOUser.getAllUsers(option);
	}

	public static List<ProgramStudents> getAllUsersByProgramID(String programID) {
		return DAOUser.getAllUsersByProgramID(programID);
	}
}
