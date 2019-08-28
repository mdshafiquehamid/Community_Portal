package org.websparrow.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.websparrow.action.Register;


public class RegisterTest {
	
	Register newUser = new Register();
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		
		newUser.setEmail("ayuni@gmail.com");
		newUser.setPassword("123456");
		newUser.setFirstname("Ayuni");
		newUser.setLastname("Binte Ahmad");
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		
		try {
		newUser.execute();
		assertEquals(1, newUser.getCtr());
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	

}
