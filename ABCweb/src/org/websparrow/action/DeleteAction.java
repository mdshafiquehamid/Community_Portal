package org.websparrow.action;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.websparrow.bean.Experiences;
import org.websparrow.bean.Qualifications;
import org.websparrow.bean.Skills;
import org.websparrow.bean.User;
import org.websparrow.dao.UserHome;

import com.opensymphony.xwork2.ActionSupport;

public class DeleteAction extends ActionSupport implements SessionAware {
	private static final long serialVersionUID = -1905974197186620917L;
	
	List<Qualifications> qualifications = null;
	List<Experiences> experiences = null;
	List<Skills> skills = null;
	User userprofile = null;
	private String submitType;
	private String email;
	private String id;
	UserHome dao = new UserHome();
	
	private Map<String, Object> userSession ;
	
	public String execute() throws Exception {
		
		userSession.get("email");
		userSession.get("password");
		
		if(submitType.equals("qualification")) {
			int i = dao.deleteQualification(id);
			
		}else if (submitType.equals("experience")) {
			int i = dao.deleteExperience(id);
			
		}else if (submitType.equals("skill")) {
			int i = dao.deleteSkill(id);
		}
		
		userprofile = getProfile();
		qualifications = fetchQualifications();
		experiences = fetchExperiences();
		skills = fetchSkills();
		
		return "DELETE";
		
	}
	
	public void setSession(Map<String, Object> session) {
		   userSession = session ;
		}
	
	public List<Skills> fetchSkills() {
		ResultSet rs = null;
		UserHome retrieve = new UserHome();
		Skills skill = null;
		List<Skills> skilllist = new ArrayList<Skills>();
		
		try {
			rs = retrieve.fetchSkills(this.email);
			int i = 0;
			if (rs != null) {
				while (rs.next()) {
					i++;
					skill = new Skills();
					skill.setSkill(rs.getString("skill"));
					skill.setId(rs.getInt("skill_id"));
					skilllist.add(skill);
				}
			}
		}catch (Exception e) {
		e.printStackTrace();
		}
		
		return skilllist;
	}
	
	public List<Experiences> fetchExperiences() {
		ResultSet rs = null;
		UserHome retrieve = new UserHome();
		Experiences experience = null;
		List<Experiences> experiencelist = new ArrayList<Experiences>();
		
		try {
			rs = retrieve.fetchExperiences(this.email);
			int i = 0;
			if (rs != null) {
				while (rs.next()) {
					i++;
					experience = new Experiences();
					experience.setId(rs.getInt("experience_id"));
					experience.setExperience_position(rs.getString("work_position"));
					experience.setExperience_company(rs.getString("company"));
					experience.setDuration(rs.getString("duration"));
					experience.setExperience_country(rs.getString("country"));
					experience.setExperience_description(rs.getString("description"));
					experiencelist.add(experience);
				}
			}
		}catch (Exception e) {
		e.printStackTrace();
		}
		
		return experiencelist;
	}
	
	
	public List<Qualifications> fetchQualifications() {
		ResultSet rs = null;
		UserHome retrieve = new UserHome();
		Qualifications qualification = null;
		List<Qualifications> qualificationlist = new ArrayList<Qualifications>();
		
		try {
			rs = retrieve.fetchQualifications(this.email);
			int i = 0;
			if (rs != null) {
				while (rs.next()) {
					i++;
					qualification = new Qualifications();
					qualification.setId(rs.getInt("qualification_id"));
					qualification.setQualification_type(rs.getString("qualification_type"));
					qualification.setQualification(rs.getString("qualification"));
					qualification.setQualification_description(rs.getString("description"));
					qualificationlist.add(qualification);
				}
			}
		}catch (Exception e) {
		e.printStackTrace();
		}
		
		return qualificationlist;
	}
	
	public User getProfile() {
		ResultSet rs = null;
		UserHome retrieve = new UserHome();
		User userprofile = null;
		
		try {
			rs = retrieve.fetchUserDetails(this.email);
			int i = 0;
			if (rs != null) {
				while (rs.next()) {
					i++;
					userprofile = new User();
					userprofile.setFirstname(rs.getString("firstname"));
					userprofile.setLastname(rs.getString("lastname"));
					userprofile.setEmail(rs.getString("email"));
					userprofile.setCompany(rs.getString("company"));
					userprofile.setPosition(rs.getString("position"));
					userprofile.setCountry(rs.getString("country"));
					userprofile.setCity(rs.getString("city"));
				}
			}
		}catch (Exception e) {
		e.printStackTrace();
		}
		
		return userprofile;
	}

	public List<Qualifications> getQualifications() {
		return qualifications;
	}

	public void setQualifications(List<Qualifications> qualifications) {
		this.qualifications = qualifications;
	}

	public List<Experiences> getExperiences() {
		return experiences;
	}

	public void setExperiences(List<Experiences> experiences) {
		this.experiences = experiences;
	}

	public List<Skills> getSkills() {
		return skills;
	}

	public void setSkills(List<Skills> skills) {
		this.skills = skills;
	}

	public User getUserprofile() {
		return userprofile;
	}

	public void setUserprofile(User userprofile) {
		this.userprofile = userprofile;
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

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Map<String, Object> getUserSession() {
		return userSession;
	}

	public void setUserSession(Map<String, Object> userSession) {
		this.userSession = userSession;
	}
	
}
