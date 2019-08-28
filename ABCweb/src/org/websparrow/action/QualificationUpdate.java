package org.websparrow.action;

import java.sql.ResultSet;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.websparrow.bean.Qualifications;
import org.websparrow.dao.UserHome;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 
 * @author Muhammad Shafique Bin Hamid mdshafique@gmail.com
 * @version 1.0
 * @since 1.0
 * @description QualificationUpdate class is for the update and create new qualification of the community portal.
 */

public class QualificationUpdate extends ActionSupport implements SessionAware {
	private static final long serialVersionUID = -1905974197186620917L;
	private String email;
	private int id;
	String submitType = "";
	Qualifications qualification= null;
	private String msg = "";
	UserHome dao = new UserHome();
	private String qualification_type ="";
	private String qualification_cert ="";
	private String qualification_description="";
	private Map<String, Object> userSession ;
	
	public String execute() throws Exception {
		
		String result = null;
		
		if(submitType.equals("viewdata")) {
			qualification = fetchQualification();
			
			result = "UPDATE";
			
		}else if(submitType.equals("update")) {
			String qualification_id = Integer.toString(this.id);
			int i = dao.updateQualifications(qualification_type, qualification_cert, qualification_description, qualification_id, email);
			qualification = fetchQualification();
			if (i > 0) {
				msg = "Record Updated Successfully";
			} else {
				msg = "error";
			}
			result = "UPDATE";
		}else if(submitType.equals("newdata")) {
			result = "NEW";
			
		}else if(submitType.equals("create")) {
			String user_id = fetchId();
			
			int i = dao.createQualification(qualification_type, qualification_cert, qualification_description, user_id);
			if (i > 0) {
				msg = "Add New Qualification";
			} else {
				msg = "error";
			}
			result = "NEW";
		}
		userSession.get("email");
		userSession.get("password");
		
		return result;
		
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

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public UserHome getDao() {
		return dao;
	}

	public void setDao(UserHome dao) {
		this.dao = dao;
	}

	public String getQualification_type() {
		return qualification_type;
	}

	public void setQualification_type(String qualification_type) {
		this.qualification_type = qualification_type;
	}

	public String getQualification_cert() {
		return qualification_cert;
	}

	public void setQualification_cert(String qualification_cert) {
		this.qualification_cert = qualification_cert;
	}

	public String getQualification_description() {
		return qualification_description;
	}

	public void setQualification_description(String qualification_description) {
		this.qualification_description = qualification_description;
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
	
	public Qualifications fetchQualification() {
		ResultSet rs = null;
		UserHome retrieve = new UserHome();
		Qualifications qualification = null;
		String qualification_id = Integer.toString(this.id);
		try {
			rs = retrieve.fetchSpecificQualification(this.email, qualification_id );
			int i = 0;
			if (rs != null) {
				while (rs.next()) {
					i++;
					qualification = new Qualifications();
					qualification.setId(rs.getInt("qualification_id"));
					qualification.setQualification_type(rs.getString("qualification_type"));
					qualification.setQualification(rs.getString("qualification"));
					qualification.setQualification_description(rs.getString("description"));
				}
			}
		}catch (Exception e) {
		e.printStackTrace();
		}
		
		return qualification;
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Qualifications getQualification() {
		return qualification;
	}

	public void setQualification(Qualifications qualification) {
		this.qualification = qualification;
	}

	

	
	
	
	
}
