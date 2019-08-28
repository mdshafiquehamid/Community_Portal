package org.websparrow.thread;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.websparrow.bean.Project;
import org.websparrow.bean.Threads;
import org.websparrow.dao.UserHome;

import com.opensymphony.xwork2.ActionSupport;

public class ThreadList extends ActionSupport implements SessionAware {
	private static final long serialVersionUID = -1905974197186620917L;
	private Map<String, Object> userSession ;
	public void setSession(Map<String, Object> session) {
		   userSession = session ;
		}
	
	UserHome dao = new UserHome();
	Threads thread = null;
	List<Threads> threadlist = null;
	private boolean noData = false;
	ResultSet rs = null;
	private String email;
	
	public String execute() throws Exception {
		
		userSession.get("email");
		userSession.get("password");
		
			try {
				threadlist = new ArrayList<Threads>();
				rs = dao.fetchThreads();
				int i = 0;
				if (rs != null) {
					while (rs.next()) {
						i++;
						thread = new Threads();
						thread.setId(rs.getInt("thread_id"));
						thread.setThread_message(rs.getString("thread_title"));
						thread.setPosted_by(rs.getString("firstname") + " " + rs.getString("lastname"));
						thread.setPosted_on(rs.getString("posted_on"));
						threadlist.add(thread);
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
				
		return "LIST";
		
	}

	public Map<String, Object> getUserSession() {
		return userSession;
	}

	public void setUserSession(Map<String, Object> userSession) {
		this.userSession = userSession;
	}

	public UserHome getDao() {
		return dao;
	}

	public void setDao(UserHome dao) {
		this.dao = dao;
	}

	public Threads getThread() {
		return thread;
	}

	public void setThread(Threads thread) {
		this.thread = thread;
	}

	public List<Threads> getThreadlist() {
		return threadlist;
	}

	public void setThreadlist(List<Threads> threadlist) {
		this.threadlist = threadlist;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
}
