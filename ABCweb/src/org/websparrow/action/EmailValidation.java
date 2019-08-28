package org.websparrow.action;

import java.sql.ResultSet;

import org.websparrow.dao.UserPreHome;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 
 * @author Muhammad Shafique Bin Hamid mdshafique@gmail.com
 * @version 1.0
 * @since 1.0
 * @description EmailValidation Action class is for the email validation functionality for the Change Password.
 */

public class EmailValidation extends ActionSupport {
	private static final long serialVersionUID = 2139116285823340125L;
	private String email;
	private String retrievedemail;
	ResultSet existinguser = null;
	UserPreHome user = new UserPreHome();
	PasswordChange passemail = new PasswordChange();

	
	/**
	 * validate() method is to validate the email that is typed in by the user in the
	 * Sign In page. Email is required and must exist in the database.
	 */
	public void validate() {
		if (email.length() == 0) {
			addFieldError("email", "Email is required.");
		}

		try {
			existinguser = user.fetchUserDetails(email);
			while (existinguser.next()) {
				this.retrievedemail = existinguser.getString("email");
			}
			if (!this.email.equals(this.retrievedemail)) {
				addFieldError("email", "User doesn't exists");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String execute() throws Exception {
		passemail.setEmail(this.email);
		return "VALIDATE";
	}

	public ResultSet getExistinguser() {
		return existinguser;
	}

	public void setExistinguser(ResultSet existinguser) {
		this.existinguser = existinguser;
	}

	public UserPreHome getUser() {
		return user;
	}

	public void setUser(UserPreHome user) {
		this.user = user;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRetrievedemail() {
		return retrievedemail;
	}

	public void setRetrievedemail(String retrievedemail) {
		this.retrievedemail = retrievedemail;
	}

}
