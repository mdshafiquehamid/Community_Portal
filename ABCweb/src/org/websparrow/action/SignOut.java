package org.websparrow.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 
 * @author Muhammad Shafique Bin Hamid mdshafique@gmail.com
 * @version 1.0
 * @since 1.0
 * @description SignOut class is for the sign out functionality of the community portal.
 */

public class SignOut extends ActionSupport implements SessionAware {
	private static final long serialVersionUID = 2139116285823340125L;
	private Map<String, Object> userSession ;
	
	public void setSession(Map<String, Object> session) {
		   userSession = session ;
		}
	
	public String execute() throws Exception {
		userSession.remove("email");
		userSession.remove("password");
		
		return "SIGNOUT";
	}

}
