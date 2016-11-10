package persistence;

import Domain.Assignment;

public interface DAOAssignmentInterface {
	void addaward(String studentId, String award);
	String checkawardLevel(double qca);
	void addqCA(String studentID,double qca);
	int getcredit(String moduleID);
	double setqCA(String studentID);
	String checkstate(String moduleID);
	Assignment getitem(String item);
}
