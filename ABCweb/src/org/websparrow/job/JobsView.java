package org.websparrow.job;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.websparrow.bean.Job;
import org.websparrow.dao.Admin;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 
 * @author Muhammad Shafique Bin Hamid mdshafique@gmail.com
 * @version 1.0
 * @since 1.0
 * @description JobsView class is for jobs listing functionality
 */
public class JobsView extends ActionSupport implements SessionAware {
	private static final long serialVersionUID = -1905974197186620917L;
	
	private String email;
	private String submitType;
	
	private Map<String, Object> userSession ;
	Admin dao = new Admin();
	Job job = null;
	List<Job> joblist = null;
	private boolean noData = false;
	ResultSet rs = null;
	
	public String execute() throws Exception {
		
		userSession.get("email");
		userSession.get("password");
		String result = null;
		
		if(submitType.equals("user")) {
			
			try {
				joblist = new ArrayList<Job>();
				rs = dao.fetchJobs();
				int i = 0;
				if (rs != null) {
					while (rs.next()) {
						i++;
						job = new Job();
						job.setId(rs.getInt("job_id"));
						job.setJob_position(rs.getString("job_position"));
						job.setJob_company(rs.getString("job_company"));
						job.setJob_description(rs.getString("job_description"));
						job.setJob_requirement(rs.getString("job_requirement"));
						job.setPosted_by(rs.getString("posted_by"));
						job.setNo_applied(rs.getInt("no_applied"));
						joblist.add(job);
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
			result = "USER";
			
		}else if(submitType.equals("admin")) {
			
			try {
				joblist = new ArrayList<Job>();
				rs = dao.fetchJobs();
				int i = 0;
				if (rs != null) {
					while (rs.next()) {
						i++;
						job = new Job();
						job.setId(rs.getInt("job_id"));
						job.setJob_position(rs.getString("job_position"));
						job.setJob_company(rs.getString("job_company"));
						job.setJob_description(rs.getString("job_description"));
						job.setJob_requirement(rs.getString("job_requirement"));
						job.setPosted_by(rs.getString("posted_by"));
						job.setNo_applied(rs.getInt("no_applied"));
						joblist.add(job);
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
			
			result = "ADMIN";
		}
		
		userSession.get("email");
		userSession.get("password");
		
		return result;
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

	public String getSubmitType() {
		return submitType;
	}

	public void setSubmitType(String submitType) {
		this.submitType = submitType;
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

	public Job getJob() {
		return job;
	}

	public void setJob(Job job) {
		this.job = job;
	}

	public List<Job> getJoblist() {
		return joblist;
	}

	public void setJoblist(List<Job> joblist) {
		this.joblist = joblist;
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
