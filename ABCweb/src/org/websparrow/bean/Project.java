package org.websparrow.bean;

public class Project extends Entity {
	
	private String project_title;
	private String project_description;
	private String project_requirement;
	private String posted_by;
	public String getProject_title() {
		return project_title;
	}
	public void setProject_title(String project_title) {
		this.project_title = project_title;
	}
	public String getProject_description() {
		return project_description;
	}
	public void setProject_description(String project_description) {
		this.project_description = project_description;
	}
	public String getProject_requirement() {
		return project_requirement;
	}
	public void setProject_requirement(String project_requirement) {
		this.project_requirement = project_requirement;
	}
	public String getPosted_by() {
		return posted_by;
	}
	public void setPosted_by(String posted_by) {
		this.posted_by = posted_by;
	}
	
	
}
