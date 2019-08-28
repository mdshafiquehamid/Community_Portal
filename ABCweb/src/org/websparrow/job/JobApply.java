package org.websparrow.job;

import java.sql.ResultSet;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.websparrow.dao.Admin;
import org.websparrow.dao.UserHome;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 
 * @author Muhammad Shafique Bin Hamid mdshafique@gmail.com
 * @version 1.0
 * @since 1.0
 * @description JobApply class is for job application functionality
 */
public class JobApply extends ActionSupport implements SessionAware {
	private static final long serialVersionUID = -1905974197186620917L;
	
	private Map<String, Object> userSession ;
	
	private String email;
	private String job_id;
	private String msg = "";
	
	Admin dao = new Admin();
	
	public String execute() throws Exception {
		
		userSession.get("email");
		userSession.get("password");
		
		String user_id = fetchId();
		int i = dao.applyJob(job_id, user_id);
		
		if (i > 0) {
			msg = "Successfully Apply For Job";
		} else {
			msg = "error";
		}
		return "APPLY";
	}
	
	public String fetchId() {
		ResultSet rs = null;
		UserHome retrieve = new UserHome();
		int id = 0;
		try {
			rs = retrieve.fetchUserDetails(this.email);
			int i = 0;
			if (rs != null) {
				while (rs.next()) {
					id = rs.getInt("id");
				}
			}
		}catch (Exception e) {
		e.printStackTrace();
		}
		String user_id = Integer.toString(id);
		return user_id;
	}
	
	
	public void setSession(Map<String, Object> session) {
		   userSession = session ;
		}



	public Map<String, Object> getUserSession() {
		return userSession;
	}

	public void setUserSession(Map<String, Object> userSession) {
		this.userSession = userSession;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getJob_id() {
		return job_id;
	}

	public void setJob_id(String job_id) {
		this.job_id = job_id;
	}

	public Admin getDao() {
		return dao;
	}

	public void setDao(Admin dao) {
		this.dao = dao;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	
}
