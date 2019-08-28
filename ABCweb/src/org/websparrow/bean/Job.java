package org.websparrow.bean;

/**
 * 
 * @author Muhammad Shafique Bin Hamid mdshafique@gmail.com
 * @version 1.0
 * @since 1.0
 * @description Job class is for the model bean for Jobs.
 */
public class Job extends Entity {
	
	private String job_position;
	private String job_company;
	private String job_description;
	private String job_requirement;
	private String posted_by;
	private int no_applied;
	private String email;
	private String firstname;
	private String lastname;
	
	public String getPosted_by() {
		return posted_by;
	}
	public void setPosted_by(String posted_by) {
		this.posted_by = posted_by;
	}

	public String getJob_position() {
		return job_position;
	}
	public void setJob_position(String job_position) {
		this.job_position = job_position;
	}
	public String getJob_company() {
		return job_company;
	}
	public void setJob_company(String job_company) {
		this.job_company = job_company;
	}
	public String getJob_description() {
		return job_description;
	}
	public void setJob_description(String job_description) {
		this.job_description = job_description;
	}
	public String getJob_requirement() {
		return job_requirement;
	}
	public void setJob_requirement(String job_requirement) {
		this.job_requirement = job_requirement;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public int getNo_applied() {
		return no_applied;
	}
	public void setNo_applied(int no_applied) {
		this.no_applied = no_applied;
	}
	
}
