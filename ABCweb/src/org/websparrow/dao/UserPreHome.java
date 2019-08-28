package org.websparrow.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 
 * @author Muhammad Shafique Bin Hamid mdshafique@gmail.com
 * @version 1.0
 * @since 1.0
 * @description UserPreHome class contains the MySQL functionalities for Pre-login
 */
public class UserPreHome implements CommonMethod {
	public static Connection getConnection() throws Exception {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			return DriverManager.getConnection("jdbc:mysql://localhost/abc?useUnicode=true&useJDBCCompliantTimezone"
		            + "Shift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "");
		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
			return null;
		}
	}
	
	public int registerUser(String firstname, String lastname, String email, String password) throws Exception {
		int i = 0;
		try {
			String sql = "INSERT INTO user (firstname, lastname, email, password, access) VALUES (?,?,?,?,?)";
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setString(1, firstname);
			ps.setString(2, lastname);
			ps.setString(3, email);
			ps.setString(4, password);
			ps.setString(5, "Y");
			i = ps.executeUpdate();
			return i;
		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
			return i;
		} finally {
			if (getConnection() != null) {
				getConnection().close();
			}
		}
	}
	
	public ResultSet fetchUserDetails(String email) throws SQLException, Exception {
		ResultSet rs = null;
		try {
			String sql = "SELECT * FROM user WHERE email=?";
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setString(1, email);
			rs = ps.executeQuery();
			return rs;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			if (getConnection() != null) {
				getConnection().close();
			}
		}
	}
	
	public int updateUserDetails(String email, String password) throws SQLException, Exception {
		getConnection().setAutoCommit(false);
		int i = 0;
		try {
			String sql = "UPDATE user SET password=? WHERE email=?";
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setString(1, password);
			ps.setString(2, email);
			i = ps.executeUpdate();
			return i;
		} catch (Exception e) {
			e.printStackTrace();
			getConnection().rollback();
			return 0;
		} finally {
			if (getConnection() != null) {
				getConnection().close();
			}
		}
	}
}
