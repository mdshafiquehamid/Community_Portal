package org.websparrow.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.websparrow.action.QualificationUpdate;

public class UpdateQualificationTest {
	
	QualificationUpdate qualification = new QualificationUpdate();

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		qualification.setEmail("lachmal@gmail.com");
		qualification.setId(5);
		qualification.setQualification_type("cert");
		qualification.setQualification_cert("");
		qualification.setQualification_description("");
		qualification.setSubmitType("update");
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void test() throws Exception {
		try {
			qualification.execute();
			assertEquals("Record Updated Successfully", qualification.getMsg());
			}catch (Exception e) {
				e.printStackTrace();
			}
	}
	
}
