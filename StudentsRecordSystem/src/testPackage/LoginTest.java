package testPackage;

import static org.junit.Assert.*;

import org.junit.Test;

import junit.framework.Assert;

public class LoginTest {

	@Test
	public void test() {
		UserManager usermanager= new UserManager();
		User user=new User(123, 123);
		usermanager.signup(user);
		
		boolean result=usermanager.login(1234,1234);
		assertTrue(result);
	}

}
