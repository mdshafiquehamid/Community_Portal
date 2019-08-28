package org.websparrow.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.websparrow.job.ResponsesView;

public class JobResponsesTest {

	ResponsesView appliedUsers = new ResponsesView();
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		appliedUsers.setJob_id("8");
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		try {
			appliedUsers.execute();
			assertEquals(true, appliedUsers.isNoData());

			}catch (Exception e) {
				e.printStackTrace();
			}
	}

}
