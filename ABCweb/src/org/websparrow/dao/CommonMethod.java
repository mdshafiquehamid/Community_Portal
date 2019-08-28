package org.websparrow.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface CommonMethod {
	
	public ResultSet fetchUserDetails(String email) throws SQLException, Exception;

}
