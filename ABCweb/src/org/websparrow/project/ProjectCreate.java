package org.websparrow.project;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.websparrow.dao.Admin;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 
 * @author Muhammad Shafique Bin Hamid mdshafique@gmail.com
 * @version 1.0
 * @since 1.0
 * @description JobCreate class is for creating job functionality
 */

public class ProjectCreate extends ActionSupport implements SessionAware {
	private static final long serialVersionUID = -1905974197186620917L;
	private String email;
	private Map<String, Object> userSession ;
	private String submitType;
	private String project_title;
	private String project_description;
	private String project_requirement;
	private String msg;
	Admin dao = new Admin();

	public String execute() throws Exception {
		
		String result = null;
		
		if(submitType.equals("new")) {
			
			result = "NEW";
			
		}else if(submitType.equals("post")) {
			int i = dao.createProject(project_title, project_description, project_requirement,email);
			if (i > 0) {
				msg = "New Project Posted";
			} else {
				msg = "error";
			}
			
			result = "UPDATE";
		}
		
		userSession.get("email");
		userSession.get("password");
		
		return result;
	}
	
	
	public void setSession(Map<String, Object> session) {
		   userSession = session ;
		}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public Map<String, Object> getUserSession() {
		return userSession;
	}


	public void setUserSession(Map<String, Object> userSession) {
		this.userSession = userSession;
	}


	public String getSubmitType() {
		return submitType;
	}


	public void setSubmitType(String submitType) {
		this.submitType = submitType;
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


	public String getMsg() {
		return msg;
	}


	public void setMsg(String msg) {
		this.msg = msg;
	}


	public Admin getDao() {
		return dao;
	}


	public void setDao(Admin dao) {
		this.dao = dao;
	}


	public String getProject_title() {
		return project_title;
	}


	public void setProject_title(String project_title) {
		this.project_title = project_title;
	}
}
