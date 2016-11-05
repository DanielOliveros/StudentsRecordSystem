package testPackage;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import Domain.Lecturer;
import Domain.ManageModules;
import Domain.Module;
import Domain.Student;
import Domain.ManageUsers;

public class ManageAllocatedModulesTest {

	@Test
	public void testManageAllocatedModule() {
		boolean result=true;
		
		try{
			Lecturer lecturer = (Lecturer) ManageUsers.signUp("idLecturer", "NameLecturer", "pass", "Lecturer");
			Module module = ManageModules.addModule("mmID", "mmName", 6, "mmDesc", "mmidProgram", "idLecturer");
			List<Module> allocatedModules = ManageAllocatedModules.getAllocatedModules(lecturer.getId()); //getAllocatedModules should be in a class called ManageAllocatedModules
			Module managedModule = allocatedModules.get(0);
			//Assess 1 student from 1 allocated module
			List<Student> registeredStudents = ManageAllocatedModules.getRegisteredStudents(managedModule);
			Student studentAssessed = registeredStudents.get(0);
			int percentage = 70;//70%
			ManageAllocatedModules.assessStudent(managedMoudle, studentAssessed, percentage);
			//after setting the percentage the system should calculate the other grades and notify the observer which is the QCA
		}catch(Exception e){
			result = false;
		}
		assertTrue(result);
	}
	
}
