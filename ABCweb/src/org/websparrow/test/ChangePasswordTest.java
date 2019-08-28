package org.websparrow.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.websparrow.action.PasswordChange;

public class ChangePasswordTest {
	
	PasswordChange user = new PasswordChange();

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		user.setEmail("lachmal@gmail.com");
		user.setNewpassword("12345678");
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		try {
			assertEquals("CHANGE", user.execute());
			assertEquals("Record Updated Successfully", user.getMsg());
			}catch (Exception e) {
				e.printStackTrace();
			}
	}
	
}
