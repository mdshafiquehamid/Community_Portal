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
 * @description SkillUpdate class is for the create new skill functionality of the community portal.
 */

public class SkillUpdate extends ActionSupport implements SessionAware {
	private static final long serialVersionUID = -1905974197186620917L;
	private String email;
	private int id;
	String submitType = "";
	Experiences experience= null;
	private String msg = "";
	UserHome dao = new UserHome();
	private String skill;
	private int skill_id;
	private Map<String, Object> userSession ;

	public String execute() throws Exception {
		String result = null;
		
		if(submitType.equals("newdata")) {
			result = "NEW";
			
		}else if(submitType.equals("create")) {
			String user_id = fetchId();
			
			int i = dao.createSkill(skill,user_id);
			if (i > 0) {
				msg = "Add New Skill";
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

	public String getSkill() {
		return skill;
	}

	public void setSkill(String skill) {
		this.skill = skill;
	}

	public int getSkill_id() {
		return skill_id;
	}

	public void setSkill_id(int skill_id) {
		this.skill_id = skill_id;
	}

}
