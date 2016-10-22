package testPackage;

import static org.junit.Assert.*;

import org.junit.Test;

import Domain.Admin;
import Domain.User;
import Domain.UserManager;

public class LoginTest {
	@Test 
	public void testLoginAndSignUp() {
		boolean result=true;
		UserManager usermanager = new UserManager();
		try{
			Admin admin = (Admin) usermanager.login();//the user must introduce admin credentials (idadmin and pass)
			User lecturer = admin.signUp();
			User student = admin.signUp();
		}catch(Exception e){
			result = false;
		}
		assertTrue(result);
	}
}
