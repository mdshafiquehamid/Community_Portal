package org.websparrow.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.websparrow.action.Login;

public class LoginTest {
	
	Login user = new Login();

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		user.setEmail("ayuni@gmail.com");
		user.setPassword("12345678");
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		try {
			user.execute();
			assertNotNull(user.getCurrentuser());
			}catch (Exception e) {
				e.printStackTrace();
			}
	}

}
