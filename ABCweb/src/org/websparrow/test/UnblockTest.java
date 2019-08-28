package org.websparrow.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.websparrow.admin.UserEdit;

public class UnblockTest {
	
	UserEdit user = new UserEdit();

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		user.setSubmitType("unblock");
		user.setEmail("ayuni@gmail.com");
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		try {
			assertEquals("EDIT", user.execute());
			assertEquals("Successfully UNBLOCK user", user.getResult_message());

			}catch (Exception e) {
				e.printStackTrace();
			}
	}

}
