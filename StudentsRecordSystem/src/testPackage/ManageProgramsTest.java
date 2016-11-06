package testPackage;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import Domain.Lecturer;
import Domain.ManageModules;
import Domain.ManagePrograms;
import Domain.ManageUsers;
import Domain.Module;
import Domain.Program;
import Domain.QPV;
import Domain.Student;

public class ManageProgramsTest {

	@Test
	public void testManageAllocatedModule() {
		boolean result=true;
		int percentage = 70;
		try{
			Lecturer lecturer = (Lecturer) ManageUsers.signUp("idLecturer", "NameLecturer", "pass", "Lecturer");
			//Student student = (Student) ManageUsers.signUp("idStudent", "NameStudent", "pass", "Student");
			Program program = ManagePrograms.addProgram("SWENG", "Software Engineering MSc", 90, "Masters in Software Engineering");
			Module module = ManageModules.addModule("SWDES", "Software Design", 6, "Software Design description", "SWENG", "idLecturer");
			List<Module> allocatedModules = ManageAllocatedModules.getAllocatedModules(lecturer.getId()); //getAllocatedModules should be in a class called ManageAllocatedModules
			Module managedModule = allocatedModules.get(0);
			//Assess 1 student from 1 allocated module
			List<QPV> qpvsToAssess = ManageAllocatedModules.getModuleQPV(managedModule);
			for(int i=0; i<qpvsToAssess.size();i++){
				ManageAllocatedModules.assessQPV(qpvsToAssess.get(i), percentage);//this method should calculate the grade and the qpv from the percentage and store it in the file.
				//it also should implement the observer pattern with QCA so when the QPV changes the QCA is updated.
			}
		}catch(Exception e){
			result = false;
		}
		assertTrue(result);
	}

}
