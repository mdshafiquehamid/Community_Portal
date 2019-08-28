package org.websparrow.action;

import java.sql.ResultSet;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.websparrow.bean.Experiences;
import org.websparrow.dao.UserHome;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 
 * @author Muhammad Shafique Bin Hamid mdshafique@gmail.com
 * @version 1.0
 * @since 1.0
 * @description ExperienceUpdate Action class is for the edit and create new experiences functionality
 */

public class ExperienceUpdate extends ActionSupport implements SessionAware {
	private static final long serialVersionUID = -1905974197186620917L;
	private String email;
	private int id;
	String submitType = "";
	Experiences experience= null;
	private String msg = "";
	UserHome dao = new UserHome();
	private String experience_company;
	private String experience_position;
	private String duration;
	private String experience_country;
	private String experience_description;
	private Map<String, Object> userSession ;
	
public String execute() throws Exception {
		
		String result = null;
		
		if(submitType.equals("viewdata")) {
			experience = fetchExperience();
			
			result = "UPDATE";
			
		}else if(submitType.equals("update")) {
			String experience_id = Integer.toString(this.id);
			int i = dao.updateExperiences(experience_company, experience_position, duration,experience_country,experience_description, experience_id, email);
			experience = fetchExperience();
			if (i > 0) {
				msg = "Record Updated Successfuly";
			} else {
				msg = "error";
			}
			result = "UPDATE";
		}else if(submitType.equals("newdata")) {
			result = "NEW";
			
		}else if(submitType.equals("create")) {
			String user_id = fetchId();
			
			int i = dao.createExperience(experience_company, experience_position, duration,experience_country,experience_description, user_id);
			if (i > 0) {
				msg = "Add New Experience";
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
	
/**
 * fetchId() method is to extract the User ID from the input email.
 * @return String of the User ID
 */
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

	/**
	 * fetchExperience() method is to extract the user's experiences from the database.
	 * @return Experience model bean
	 */
	public Experiences fetchExperience() {
		ResultSet rs = null;
		UserHome retrieve = new UserHome();
		Experiences experience = null;
		String experience_id = Integer.toString(this.id);
		try {
			rs = retrieve.fetchSpecificExperience(this.email, experience_id );
			int i = 0;
			if (rs != null) {
				while (rs.next()) {
					i++;
					experience = new Experiences();
					experience.setId(rs.getInt("experience_id"));
					experience.setExperience_company(rs.getString("company"));
					experience.setExperience_position(rs.getString("work_position"));
					experience.setDuration(rs.getString("duration"));
					experience.setExperience_country(rs.getString("country"));
					experience.setExperience_description(rs.getString("description"));
				}
			}
		}catch (Exception e) {
		e.printStackTrace();
		}
		
		return experience;
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

	public String getSubmitType() {
		return submitType;
	}

	public void setSubmitType(String submitType) {
		this.submitType = submitType;
	}

	public Experiences getExperience() {
		return experience;
	}

	public void setExperience(Experiences experience) {
		this.experience = experience;
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

	public String getExperience_company() {
		return experience_company;
	}

	public void setExperience_company(String experience_company) {
		this.experience_company = experience_company;
	}

	public String getExperience_position() {
		return experience_position;
	}

	public void setExperience_position(String experience_position) {
		this.experience_position = experience_position;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public String getExperience_country() {
		return experience_country;
	}

	public void setExperience_country(String experience_country) {
		this.experience_country = experience_country;
	}

	public String getExperience_description() {
		return experience_description;
	}

	public void setExperience_description(String experience_description) {
		this.experience_description = experience_description;
	}
}
