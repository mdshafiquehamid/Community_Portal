package org.websparrow.bean;

public class Message extends Entity {
	private String message;
	private String sent_on;
	private String firstname;
	private String lastname;
	private int user_id;
	private int recipient_id;
	private String user_email;
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getSent_on() {
		return sent_on;
	}
	public void setSent_on(String sent_on) {
		this.sent_on = sent_on;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getRecipient_id() {
		return recipient_id;
	}
	public void setRecipient_id(int recipient_id) {
		this.recipient_id = recipient_id;
	}
	public String getUser_email() {
		return user_email;
	}
	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}

}
