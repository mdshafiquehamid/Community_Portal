package org.websparrow.job;

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
public class JobCreate extends ActionSupport implements SessionAware {
	private static final long serialVersionUID = -1905974197186620917L;
	private String email;
	private Map<String, Object> userSession ;
	private String submitType;
	private String job_position;
	private String job_company;
	private String job_description;
	private String job_requirement;
	private String msg;
	Admin dao = new Admin();
	
public String execute() throws Exception {
		
		String result = null;
		
		if(submitType.equals("new")) {
			
			result = "NEW";
			
		}else if(submitType.equals("post")) {
			int i = dao.createJob(job_position,job_company,job_description,job_requirement,email);
			if (i > 0) {
				msg = "New Job Posted";
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
}
