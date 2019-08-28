package org.websparrow.action;


import org.websparrow.dao.UserPreHome;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 
 * @author Muhammad Shafique Bin Hamid mdshafique@gmail.com
 * @version 1.0
 * @since 1.0
 * @description PasswordChange class is for the change password functionality of the community portal.
 */

public class PasswordChange extends ActionSupport {
	private static final long serialVersionUID = 2139116285823340125L;
	private String email;
	UserPreHome user = new UserPreHome();
	private String newpassword;
	private String repassword;
	private String msg ="";
	
	public void validate(){
	    if (newpassword.length() == 0) {
	        addFieldError("newpassword", "Password is required.");
	    }
	    if(newpassword.length() < 8) {
	    	 addFieldError("newpassword", "Min length is 8 characters.");
	    }
	    if (repassword.length() == 0) {
	        addFieldError("repassword", "Please Re-enter your password.");
	    }
	    
	    if(!repassword.equals(newpassword)) {
	    	addFieldError("repassword", "Does not match your password.");
	    } 
	}
	
	public String execute() throws Exception {
		
		try {
			int i = user.updateUserDetails(email,newpassword);
			if (i > 0) {
				
				msg = "Record Updated Successfully";
			} else {
				msg = "error";
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return "CHANGE";
	}
	
	public UserPreHome getUser() {
		return user;
	}

	public void setUser(UserPreHome user) {
		this.user = user;
	}

	public String getNewpassword() {
		return newpassword;
	}

	public void setNewpassword(String newpassword) {
		this.newpassword = newpassword;
	}

	public String getRepassword() {
		return repassword;
	}

	public void setRepassword(String repassword) {
		this.repassword = repassword;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}
