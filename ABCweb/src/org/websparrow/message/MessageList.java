package org.websparrow.message;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.websparrow.bean.Message;
import org.websparrow.dao.UserHome;

import com.opensymphony.xwork2.ActionSupport;

public class MessageList extends ActionSupport implements SessionAware {
	private static final long serialVersionUID = -1905974197186620917L;
	private Map<String, Object> userSession ;
	public void setSession(Map<String, Object> session) {
		   userSession = session ;
	}
	
	UserHome dao = new UserHome();
	Message message = null;
	List<Message> messageslist = null;
	
	private String user_email;
	private String recipient_email;
	private String user_id;
	private String recipient_id;
	private boolean noData = false;
	ResultSet rs = null;
	
	
public String execute() throws Exception {
		
		userSession.get("email");
		userSession.get("password");
		
		user_id = fetchId(user_email);
		recipient_id = fetchId(recipient_email);
		
			try {
				messageslist = new ArrayList<Message>();
				rs = dao.fetchMessages(user_id,recipient_id);
				int i = 0;
				if (rs != null) {
					while (rs.next()) {
						i++;
						message = new Message();
						message.setId(rs.getInt("message_id"));
						message.setUser_id(rs.getInt("user_id"));
						message.setRecipient_id(rs.getInt("recipient_id"));
						message.setMessage(rs.getString("message"));
						message.setSent_on(rs.getString("sent_on"));
						message.setFirstname(rs.getString("firstname"));
						message.setLastname(rs.getString("lastname"));
						message.setUser_email(rs.getString("user_email"));
						messageslist.add(message);
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

	public String fetchId(String email) {
		ResultSet rs = null;
		UserHome retrieve = new UserHome();
		int id = 0;
		try {
			rs = retrieve.fetchUserDetails(email);
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

	public Message getMessage() {
		return message;
	}

	public void setMessage(Message message) {
		this.message = message;
	}

	public List<Message> getMessageslist() {
		return messageslist;
	}

	public void setMessageslist(List<Message> messageslist) {
		this.messageslist = messageslist;
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

	public String getUser_email() {
		return user_email;
	}

	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}

	public String getRecipient_email() {
		return recipient_email;
	}

	public void setRecipient_email(String recipient_email) {
		this.recipient_email = recipient_email;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getRecipient_id() {
		return recipient_id;
	}

	public void setRecipient_id(String recipient_id) {
		this.recipient_id = recipient_id;
	}
	
	
}
