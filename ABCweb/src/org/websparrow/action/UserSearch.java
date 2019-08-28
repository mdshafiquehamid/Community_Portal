package org.websparrow.action;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.websparrow.bean.User;
import org.websparrow.dao.UserHome;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 
 * @author Muhammad Shafique Bin Hamid mdshafique@gmail.com
 * @version 1.0
 * @since 1.0
 * @description UserSearch class is for the search user functionality of the community portal.
 */

public class UserSearch extends ActionSupport implements SessionAware {
	private static final long serialVersionUID = 2139116285823340125L;
	private String searchquery;
	User user = null;
	List<User> userlist = null;
	private boolean noData = false;
	UserHome retrieve = new UserHome();
	ResultSet rs = null;
	private Map<String, Object> userSession ;
	
	public String execute() throws Exception {
		try {
			userlist = new ArrayList<User>();
			rs = retrieve.fetchSearchedUsers(searchquery);
			int i = 0;
			if (rs != null) {
				while (rs.next()) {
					i++;
					user = new User();
					user.setId(i);
					user.setFirstname(rs.getString("firstname"));
					user.setLastname(rs.getString("lastname"));
					user.setEmail(rs.getString("email"));
					user.setCompany(rs.getString("company"));
					user.setPosition(rs.getString("position"));
					user.setCountry(rs.getString("country"));
					user.setCity(rs.getString("city"));
					userlist.add(user);
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
		
		userSession.get("email");
		userSession.get("password");
		
		return "SEARCH";
	}
	
	public void setSession(Map<String, Object> session) {
		   userSession = session ;
		}

	public Map<String, Object> getUserSession() {
		return userSession;
	}

	public void setUserSession(Map<String, Object> userSession) {
		this.userSession = userSession;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<User> getUserlist() {
		return userlist;
	}

	public void setUserlist(List<User> userlist) {
		this.userlist = userlist;
	}

	public boolean isNoData() {
		return noData;
	}

	public void setNoData(boolean noData) {
		this.noData = noData;
	}

	public UserHome getRetrieve() {
		return retrieve;
	}

	public void setRetrieve(UserHome retrieve) {
		this.retrieve = retrieve;
	}

	public ResultSet getRs() {
		return rs;
	}

	public void setRs(ResultSet rs) {
		this.rs = rs;
	}

	public String getSearchquery() {
		return searchquery;
	}
	public void setSearchquery(String searchquery) {
		this.searchquery = searchquery;
	}
}
