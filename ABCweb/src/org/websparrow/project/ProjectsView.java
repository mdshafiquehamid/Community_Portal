package org.websparrow.project;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.websparrow.bean.Project;
import org.websparrow.dao.Admin;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 
 * @author Muhammad Shafique Bin Hamid mdshafique@gmail.com
 * @version 1.0
 * @since 1.0
 * @description JobsView class is for jobs listing functionality
 */

public class ProjectsView extends ActionSupport implements SessionAware {
	private static final long serialVersionUID = -1905974197186620917L;
	private String email;
	
	private Map<String, Object> userSession ;
	Admin dao = new Admin();
	Project project = null;
	List<Project> projectlist = null;
	private boolean noData = false;
	ResultSet rs = null;
	
	public String execute() throws Exception {
		
		userSession.get("email");
		userSession.get("password");
		
		try {
			projectlist = new ArrayList<Project>();
			rs = dao.fetchProjects();
			int i = 0;
			if (rs != null) {
				while (rs.next()) {
					i++;
					project = new Project();
					project.setId(rs.getInt("project_id"));
					project.setProject_title(rs.getString("project_title"));
					project.setProject_description(rs.getString("project_description"));
					project.setProject_requirement(rs.getString("project_requirement"));
					project.setPosted_by(rs.getString("posted_by"));
					projectlist.add(project);
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
		
		return "VIEWPROJECTS";
	}
	
	public void setSession(Map<String, Object> session) {
		   userSession = session ;
		}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Map<String, Object> getUserSession() {
		return userSession;
	}

	public void setUserSession(Map<String, Object> userSession) {
		this.userSession = userSession;
	}

	public Admin getDao() {
		return dao;
	}

	public void setDao(Admin dao) {
		this.dao = dao;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public List<Project> getProjectlist() {
		return projectlist;
	}

	public void setProjectlist(List<Project> projectlist) {
		this.projectlist = projectlist;
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
