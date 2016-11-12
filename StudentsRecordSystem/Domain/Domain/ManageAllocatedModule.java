package Domain;

import java.util.List;
import java.util.Observer;

import persistence.DAOAssignment;

public class ManageAllocatedModule {

	public static String checkState(String moduleID) {
		return DAOAssignment.checkState(moduleID);
	}

	public static Assignment addAssignment(String name, String moduleId, String description, int percentage) {
		Assignment assignment;
		if (DAOAssignment.getItem(name) == null) {
			String result = DAOAssignment.checkBeforeAdd(moduleId, percentage);
			if (result == "not ready" || result == "ready") {
				assignment = new Assignment(name, moduleId, description, percentage);
				DAOAssignment.createAssignment(assignment);
			} else {
				assignment = null;
			}
		} else {
			assignment = null;
		}
		return assignment;
	}

	public static List<Module> getUserModule(String lecturerID) {
		return DAOAssignment.getUserModule(lecturerID);
	}

	public static List<Assignment> getModuleAssignment(String moduleID) {
		return DAOAssignment.getModuleAssignment(moduleID);
	}

	public static void setGrade(String studentID, String moduleID) {
		int total = DAOAssignment.setGrade(studentID, moduleID);
		String grade = DAOAssignment.chekGradeLevel(total);
		DAOAssignment.update(studentID, moduleID, grade);
		grade = grade.substring(0, 1);
		double checkqpv = DAOAssignment.chekQPVLevel(grade);
		DAOAssignment.setQPV(studentID, moduleID, checkqpv);
		int percentage = DAOAssignment.chekPercentage(checkqpv);
		
		DAOAssignment.setPercentage(studentID, moduleID, percentage);
		
		//Observer pattern
		QPV qpv = new QPV(moduleID,studentID,grade,checkqpv,percentage);
		Observer qca = new QCA(qpv);
		String sIDqpv=studentID;
		qpv.setData(sIDqpv);
	}

	public static void setQCA(String studentId) {
		double qca=DAOAssignment.setQCA(studentId);
		DAOAssignment.addQCA(studentId,qca);
		String award = DAOAssignment.checkAwardLevel(qca);
		DAOAssignment.addAward(studentId, award);
	}

}
