package org.websparrow.thread;

import java.sql.ResultSet;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.websparrow.bean.Threads;
import org.websparrow.dao.UserHome;

import com.opensymphony.xwork2.ActionSupport;

public class ThreadCreate extends ActionSupport implements SessionAware {
	private static final long serialVersionUID = -1905974197186620917L;
	private Map<String, Object> userSession ;
	public void setSession(Map<String, Object> session) {
		   userSession = session ;
		}
	
	UserHome dao = new UserHome();
	private String email;
	private String submitType;
	private String thread_message;
	private String msg;
	
	public String execute() throws Exception {
		userSession.get("email");
		userSession.get("password");
		
		String result = null;
		
		if(submitType.equals("new")) {
			
			result = "NEW";
			
		}else if(submitType.equals("post")) {
			String user_id = fetchId();
			int i = dao.createThread(thread_message, user_id);
			if (i > 0) {
				msg = "New Thread Posted";
			} else {
				msg = "error";
			}
			
			result = "POST";
		}
		
		return result;
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

	public Map<String, Object> getUserSession() {
		return userSession;
	}

	public void setUserSession(Map<String, Object> userSession) {
		this.userSession = userSession;
	}

	public UserHome getDao() {
		return dao;
	}

	public void setDao(UserHome dao) {
		this.dao = dao;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSubmitType() {
		return submitType;
	}

	public void setSubmitType(String submitType) {
		this.submitType = submitType;
	}

	public String getThread_message() {
		return thread_message;
	}

	public void setThread_message(String thread_message) {
		this.thread_message = thread_message;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
		
}
