package testPackage;

import static org.junit.Assert.*;

import org.junit.Test;

import Domain.Admin;
import Domain.Lecturer;
import Domain.ManageLogin;
import Domain.ManageUsers;
import Domain.Student;

public class LoginTest {
	@Test 
	public void testLoginAndSignUp() {
		boolean result=true;
		try{
			ManageLogin loginManager = ManageLogin.getManageLogin();
			ManageUsers usersManager = ManageUsers.getManageUsers();
			Admin admin = (Admin) loginManager.login("idadmin", "pass");
			Student student = (Student) usersManager.signUp("idStudent", "NameStudent", "pass", "Student");
			Lecturer lecturer = (Lecturer) usersManager.signUp("idLecturer", "NameLecturer", "pass", "Student");
		}catch(Exception e){
			result = false;
		}
		assertTrue(result);
	}
}
