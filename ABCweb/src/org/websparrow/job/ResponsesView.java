package org.websparrow.job;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.websparrow.bean.User;
import org.websparrow.dao.Admin;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 
 * @author Muhammad Shafique Bin Hamid mdshafique@gmail.com
 * @version 1.0
 * @since 1.0
 * @description ResponsesView class is for viewing the applicants for a job functionality
 */
public class ResponsesView extends ActionSupport implements SessionAware{
	private static final long serialVersionUID = -1905974197186620917L;
	
	private Map<String, Object> userSession ;
	private String email;
	private String job_id;
	private String job_position;
	private String job_company;
	private String job_description;
	private String job_requirement;
	private String posted_by;
	private String no_applied;
	
	Admin dao = new Admin();
	User user = null;
	List<User> userlist = null;
	private boolean noData = false;
	ResultSet rs = null;
	
	public String execute() throws Exception {
		userSession.get("email");
		userSession.get("password");
		
		try {
			userlist = new ArrayList<User>();
			rs = dao.fetchApplicants(job_id);
			int i = 0;
			if (rs != null) {
				while (rs.next()) {
					i++;
					user = new User();
					user.setId(i);
					user.setFirstname(rs.getString("firstname"));
					user.setLastname(rs.getString("lastname"));
					user.setEmail(rs.getString("email"));
					userlist.add(user);
				}
			}
			if (i == 0) {
				noData = false;
			} else {
				noData = true;
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return "VIEW";
		
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

	public String getPosted_by() {
		return posted_by;
	}

	public void setPosted_by(String posted_by) {
		this.posted_by = posted_by;
	}

	public String getNo_applied() {
		return no_applied;
	}

	public void setNo_applied(String no_applied) {
		this.no_applied = no_applied;
	}

	public Admin getDao() {
		return dao;
	}

	public void setDao(Admin dao) {
		this.dao = dao;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<User> getUserlist() {
		return userlist;
	}

	public void setUserlist(List<User> userlist) {
		this.userlist = userlist;
	}

	public boolean isNoData() {
		return noData;
	}

	public void setNoData(boolean noData) {
		this.noData = noData;
	}

	public ResultSet getRs() {
		return rs;
	}

	public void setRs(ResultSet rs) {
		this.rs = rs;
	}

}
