package testPackage;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import Domain.ManageProgram;

public class ManageProgramsTest {

	@Test
	public void test() {
		boolean result=true;
		try{
			ManageProgram mp = new ManageProgram();
			mp.choose();
		}catch(Exception e){
			result = false;
		}
		assertTrue(result);
	}

}
