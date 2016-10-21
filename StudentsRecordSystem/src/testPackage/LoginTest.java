package testPackage;

import static org.junit.Assert.*;

import org.junit.Test;

import junit.framework.Assert;
import mainPackage.UserManager;

public class LoginTest {

	@Test
<<<<<<< HEAD
	public void test() {
		assertTrue(false);
		//comment hjhjhj
=======
	public void testSign() {
		boolean result=false;
		String password="pass", idAdmin="idAdmin", idLecturer="idLecturer", idStudent="idStudent";
		try{
			UserManager usermanager = new UserManager();
			User admin = usermanager.signUp(idAdmin, password, "Admin");//returns an Admin object
			User lecturer= usermanager.signUp(idLecturer, password, "Lecturer"); //returns a Lecturer object
			User student = usermanager.signUp(idStudent, password, "Student");//returns a Student object
			
			admin=usermanager.login(idAdmin, password);
			lecturer=usermanager.login(idLecturer, password);
			student=usermanager.login(idStudent, password);
		}catch(Exception e){
			result = false;
		}	
		assertTrue(result);
>>>>>>> branch 'master' of https://github.com/DanielOliveros/StudentsRecordSystem.git
	}

}
