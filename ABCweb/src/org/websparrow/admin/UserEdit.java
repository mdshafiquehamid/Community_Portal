package org.websparrow.admin;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.websparrow.dao.Admin;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 
 * @author Muhammad Shafique Bin Hamid mdshafique@gmail.com
 * @version 1.0
 * @since 1.0
 * @description UserEdit class is for the block and unblock user functionality of the community portal.
 */
public class UserEdit extends ActionSupport implements SessionAware {
	private static final long serialVersionUID = 2139116285823340125L;
	private Map<String, Object> userSession;
	private String submitType;
	private String email;
	private String result_message;
	Admin retrieve = new Admin();
	
	public String execute() throws Exception {
		userSession.get("email");
		userSession.get("password");
		
		if(submitType.equals("block")) {
			
			try {
				retrieve.editUser(email,"N");
			}catch (Exception e) {
				e.printStackTrace();
			}
			
			this.result_message = "Successfully BLOCK user";
			
		}else if(submitType.equals("unblock")) {
			
			try {
				retrieve.editUser(email,"Y");
			}catch (Exception e) {
				e.printStackTrace();
			}
			this.result_message = "Successfully UNBLOCK user";
		}
		return "EDIT";
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

	public String getSubmitType() {
		return submitType;
	}

	public void setSubmitType(String submitType) {
		this.submitType = submitType;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getResult_message() {
		return result_message;
	}

	public void setResult_message(String result_message) {
		this.result_message = result_message;
	}

	public Admin getRetrieve() {
		return retrieve;
	}

	public void setRetrieve(Admin retrieve) {
		this.retrieve = retrieve;
	}
	
}
