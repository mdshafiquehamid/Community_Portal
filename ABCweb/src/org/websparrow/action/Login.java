package org.websparrow.action;

import java.sql.ResultSet;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.websparrow.bean.User;
import org.websparrow.dao.UserHome;
import org.websparrow.dao.UserPreHome;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 
 * @author Muhammad Shafique Bin Hamid mdshafique@gmail.com
 * @version 1.0
 * @since 1.0
 * @description Login Action class is for the login functionality of the community portal.
 */

public class Login extends ActionSupport implements SessionAware {
	private static final long serialVersionUID = 2139116285823340125L;
	private String email;
	private String password;
	ResultSet existinguser = null;
	UserPreHome user = new UserPreHome();
	private String passwordretrieve;
	private String emailretrieve;
	User currentuser = null;
	ResultSet rs = null;
	UserHome retrieve = new UserHome();
	private Map<String, Object> userSession ;
	private String access;
	
	public String execute() throws Exception {
		
		userSession.put("email",this.email);
		userSession.put("password",this.password);
		
		String result="";
		
		if(email.equals("administrator@abc.com")) {
			try {
				rs = retrieve.fetchUserDetails(email);
				if (rs != null) {
					while (rs.next()) {
						currentuser =  new User();
						currentuser.setFirstname(rs.getString("firstname"));
					}
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
			
			result = "ADMIN";
			
		}else {
			
			try {
				rs = retrieve.fetchUserDetails(email);
				if (rs != null) {
					while (rs.next()) {
						currentuser =  new User();
						currentuser.setFirstname(rs.getString("firstname"));
						currentuser.setLastname(rs.getString("lastname"));
						currentuser.setPosition(rs.getString("position"));
						currentuser.setCompany(rs.getString("company"));
						currentuser.setCountry(rs.getString("country"));
						currentuser.setCity(rs.getString("city"));
					}
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
			
			result = "SIGNIN";
		}
	
		return result;
	}
	
	public void setSession(Map<String, Object> session) {
		   userSession = session ;
		}

	public UserPreHome getUser() {
		return user;
	}

	public void setUser(UserPreHome user) {
		this.user = user;
	}

	public User getCurrentuser() {
		return currentuser;
	}

	public void setCurrentuser(User currentuser) {
		this.currentuser = currentuser;
	}

	public ResultSet getRs() {
		return rs;
	}

	public void setRs(ResultSet rs) {
		this.rs = rs;
	}

	public String getEmailretrieve() {
		return emailretrieve;
	}

	public void setEmailretrieve(String emailretrieve) {
		this.emailretrieve = emailretrieve;
	}

/**
 * validate() method is to validate the email and password that is typed in by the user in the
 * Sign In page. Email is required and must exist in the database. Password is required and must belong
 * to the user with that particular email. The user must also have access to the community portal. 
 */
	
	public void validate(){
		if (email.length() == 0) {
	        addFieldError("email", "Email is required.");
	    }
	    if (password.length() == 0) {
	        addFieldError("password", "Password is required.");

	    }
	    
		try {
			existinguser = user.fetchUserDetails(email);
			while (existinguser.next()) {
				this.passwordretrieve = existinguser.getString("password");
				this.emailretrieve = existinguser.getString("email");
				this.access = existinguser.getString("access");
				
			}
			if(!this.email.equals(this.emailretrieve)) {
				addFieldError("email", "User doesn't exists");
				
			}else if(!this.password.equals(this.passwordretrieve)) {
				addFieldError("password", "Password is incorrect");
				
			}else if(this.access.equals("N")) {
				addFieldError("email", "User not allowed access");
			}
		}catch (Exception e) {
			e.printStackTrace();
		} 
	}
	
	public String getPasswordretrieve() {
		return passwordretrieve;
	}


	public void setPasswordretrieve(String passwordretrieve) {
		this.passwordretrieve = passwordretrieve;
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

	public ResultSet getExistinguser() {
		return existinguser;
	}

	public void setExistinguser(ResultSet existinguser) {
		this.existinguser = existinguser;
	}

	public UserHome getRetrieve() {
		return retrieve;
	}

	public void setRetrieve(UserHome retrieve) {
		this.retrieve = retrieve;
	}

	public Map<String, Object> getUserSession() {
		return userSession;
	}

	public void setUserSession(Map<String, Object> userSession) {
		this.userSession = userSession;
	}

}
