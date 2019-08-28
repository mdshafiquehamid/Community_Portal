package org.websparrow.thread;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.websparrow.bean.Threads;
import org.websparrow.bean.User;
import org.websparrow.dao.UserHome;

import com.opensymphony.xwork2.ActionSupport;

public class ThreadReply extends ActionSupport implements SessionAware {

	private static final long serialVersionUID = -1905974197186620917L;
	private Map<String, Object> userSession ;
	public void setSession(Map<String, Object> session) {
		   userSession = session ;
		}
	
	UserHome dao = new UserHome();
	private String submitType;
	private String thread_id;
	Threads thread = null;
	ResultSet rs = null;
	Threads reply = null;
	List<Threads> replies = null;
	private String thread_message;
	private String email;
	
	public String execute() throws Exception {
		userSession.get("email");
		userSession.get("password");
		String result = null;
		
		if(submitType.equals("list")) {
			this.thread = fetchThread();
			this.replies = fetchReplies();
			result = "LIST";
			
		}else if(submitType.equals("reply")) {
			String user_id = fetchId();
			int i = dao.replyThread(thread_id, thread_message, user_id);
			this.thread = fetchThread();
			this.replies = fetchReplies();
			result = "REPLY";
		}
		
		return result;
	}
	
	public Threads fetchThread() throws Exception {
		
		Threads thread = null;
		ResultSet rs = null;
		
		try {
			rs = dao.fetchThread(thread_id);
			int i = 0;
			if (rs != null) {
				while (rs.next()) {
					thread = new Threads();
					thread.setId(rs.getInt("thread_id"));
					thread.setThread_message(rs.getString("thread_title"));
					thread.setPosted_by(rs.getString("firstname") + " " + rs.getString("lastname"));
					thread.setPosted_on(rs.getString("posted_on"));
				}
			}
		}catch (Exception e) {
		e.printStackTrace();
		}
		
		return thread;
		
	}
	
	public List<Threads> fetchReplies() throws Exception {
		Threads reply = null;
		List<Threads> replies = null;
		ResultSet rs = null;
		
			try {
				replies = new ArrayList<Threads>();
				rs = dao.fetchReplies(thread_id);
				int i = 0;
				if (rs != null) {
					while (rs.next()) {
						i++;
						reply = new Threads();
						reply.setId(rs.getInt("reply_id"));
						reply.setThread_message(rs.getString("thread_reply"));
						reply.setPosted_by(rs.getString("firstname") + " " + rs.getString("lastname"));
						reply.setPosted_on(rs.getString("posted_on"));
						replies.add(reply);
					}
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
			
			return replies;
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

	public String getSubmitType() {
		return submitType;
	}

	public void setSubmitType(String submitType) {
		this.submitType = submitType;
	}

	public String getThread_id() {
		return thread_id;
	}

	public void setThread_id(String thread_id) {
		this.thread_id = thread_id;
	}

	public Threads getThread() {
		return thread;
	}

	public void setThread(Threads thread) {
		this.thread = thread;
	}

	public ResultSet getRs() {
		return rs;
	}

	public void setRs(ResultSet rs) {
		this.rs = rs;
	}

	public Threads getReply() {
		return reply;
	}

	public void setReply(Threads reply) {
		this.reply = reply;
	}

	public List<Threads> getReplies() {
		return replies;
	}

	public void setReplies(List<Threads> replies) {
		this.replies = replies;
	}

	public String getThread_message() {
		return thread_message;
	}

	public void setThread_message(String thread_message) {
		this.thread_message = thread_message;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
