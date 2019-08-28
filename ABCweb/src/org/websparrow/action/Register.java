package org.websparrow.action;

import java.sql.ResultSet;

import org.websparrow.bean.User;
import org.websparrow.dao.UserPreHome;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 
 * @author Muhammad Shafique Bin Hamid mdshafique@gmail.com
 * @version 1.0
 * @since 1.0
 * @description Register class is for the registration functionality of the community portal.
 */

public class Register extends ActionSupport {
	private static final long serialVersionUID = 2139116285823340125L;
	private String firstname;
	private String lastname;
	private String email;
	private String password;
	private String repassword;
	UserPreHome newuser = null;
	int ctr = 0;
	UserPreHome retrieve = new UserPreHome();
	ResultSet rs = null;
	
	public void validate(){
	    if (firstname.length() == 0) {
	        addFieldError("firstname", "First name is required.");
	    }
	    if (email.length() == 0) {
	        addFieldError("email", "Email is required.");
	    }
	    if (password.length() == 0) {
	        addFieldError("password", "Password is required.");
	    }
	    if(password.length() < 8) {
	    	 addFieldError("password", "Min length is 8 characters.");
	    }
	    if (repassword.length() == 0) {
	        addFieldError("repassword", "Please Re-enter your password.");
	    }
	    
	    if(!repassword.equals(password)) {
	    	addFieldError("repassword", "Does not match your password.");
	    }
	    
	    try {
			rs = retrieve.fetchUserDetails(email);
		}catch (Exception e) {
			e.printStackTrace();
		}
	    
	    if (rs != null) {
	    	addFieldError("email", "User already exists. Please use another email.");
	    }
	}
	
	public UserPreHome getNewuser() {
		return newuser;
	}

	public void setNewuser(UserPreHome newuser) {
		this.newuser = newuser;
	}

	public int getCtr() {
		return ctr;
	}

	public void setCtr(int ctr) {
		this.ctr = ctr;
	}

	public String execute() throws Exception {
		newuser = new UserPreHome();
		
		try {
			ctr = newuser.registerUser(firstname.toLowerCase(), lastname.toLowerCase(), email, password);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "REGISTER";
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


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getRepassword() {
		return repassword;
	}


	public void setRepassword(String repassword) {
		this.repassword = repassword;
	}
	
}
