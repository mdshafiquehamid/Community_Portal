package org.websparrow.message;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.websparrow.bean.Message;
import org.websparrow.dao.UserHome;

import com.opensymphony.xwork2.ActionSupport;

public class MessageReply extends ActionSupport implements SessionAware {
	private static final long serialVersionUID = -1905974197186620917L;
	private Map<String, Object> userSession ;
	public void setSession(Map<String, Object> session) {
		   userSession = session ;
	}
	UserHome dao = new UserHome();
	Message message = null;
	List<Message> messageslist = null;
	
	private String user_email;
	private String user_id;
	private String recipient_id;
	private boolean noData = false;
	ResultSet rs = null;
	
	private String message_reply;
	
	
public String execute() throws Exception {
		
		userSession.get("email");
		userSession.get("password");
		
		dao.message(message_reply, user_id, recipient_id, user_email);
		
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
				
		return "REPLY";
		
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


public String getUser_email() {
	return user_email;
}


public void setUser_email(String user_email) {
	this.user_email = user_email;
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


public String getMessage_reply() {
	return message_reply;
}


public void setMessage_reply(String message_reply) {
	this.message_reply = message_reply;
}


}
