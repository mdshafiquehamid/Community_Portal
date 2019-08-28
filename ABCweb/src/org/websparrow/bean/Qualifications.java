package org.websparrow.bean;

/**
 * 
 * @author Muhammad Shafique Bin Hamid mdshafique@gmail.com
 * @version 1.0
 * @since 1.0
 * @description Qualifications class is for the model bean for Qualification.
 */
public class Qualifications extends Entity {
	private String qualification_type;
	private String qualification;
	private String qualification_description;
	
	public String getQualification_type() {
		return qualification_type;
	}
	public void setQualification_type(String qualification_type) {
		this.qualification_type = qualification_type;
	}
	public String getQualification() {
		return qualification;
	}
	public void setQualification(String qualification) {
		this.qualification = qualification;
	}
	public String getQualification_description() {
		return qualification_description;
	}
	public void setQualification_description(String qualification_description) {
		this.qualification_description = qualification_description;
	}

}
