package org.websparrow.bean;

public class Threads extends Entity {
	private String thread_message;
	private String posted_by;
	private String posted_on;

	public String getThread_message() {
		return thread_message;
	}
	public void setThread_message(String thread_message) {
		this.thread_message = thread_message;
	}
	public String getPosted_by() {
		return posted_by;
	}
	public void setPosted_by(String posted_by) {
		this.posted_by = posted_by;
	}
	public String getPosted_on() {
		return posted_on;
	}
	public void setPosted_on(String posted_on) {
		this.posted_on = posted_on;
	}
}
