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
 * @description Admin class contains the MySQL functionalities for Administrator
 */

public class Admin {

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
    
	public ResultSet fetchUsers() throws SQLException, Exception {
		
		ResultSet rs = null;
		try {
			String sql = "SELECT * FROM `user` LEFT JOIN address ON user.id = address.id";
			PreparedStatement ps = getConnection().prepareStatement(sql);
			rs = ps.executeQuery();
			return rs;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			if (getConnection()!= null) {
				getConnection().close();
			}
		}
	}
	
	public int editUser(String email, String access) throws SQLException, Exception {
		
		getConnection().setAutoCommit(false);
		int i = 0;
		try {
			String sql = "UPDATE user SET access=? WHERE email=?";
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setString(1, access);
			ps.setString(2, email);
			i = ps.executeUpdate();
			return i;
		} catch (Exception e) {
			e.printStackTrace();
			getConnection().rollback();
			return 0;
		} finally {
			if (getConnection()!= null) {
				getConnection().close();
			}
		}
	}
	
	public int createJob(String job_position, String job_company, String job_description, String job_requirement, String email) throws Exception {
	
		int i = 0;
		try {
			String sql = "INSERT INTO jobs (job_position, job_company, job_description, job_requirement, posted_by) VALUES (?,?,?,?,?)";
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setString(1, job_position);
			ps.setString(2, job_company);
			ps.setString(3, job_description);
			ps.setString(4, job_requirement);
			ps.setString(5, email);
			i = ps.executeUpdate();
			return i;
		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
			return i;
		} finally {
			if (getConnection()!= null) {
				getConnection().close();
			}
		}
	}
	
	public ResultSet fetchJobs() throws SQLException, Exception {

		ResultSet rs = null;
		try {
			String sql = "SELECT jobs.job_id, jobs.job_position, jobs.job_company, jobs.job_description, jobs.job_requirement, jobs.posted_by, COUNT(job_user.user_id) AS no_applied  \r\n" + 
					"FROM `jobs`\r\n" + 
					"LEFT JOIN job_user\r\n" + 
					"ON jobs.job_id = job_user.job_id\r\n" + 
					"GROUP BY jobs.job_id;";
			PreparedStatement ps = getConnection().prepareStatement(sql);
			rs = ps.executeQuery();
			return rs;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			if (getConnection()!= null) {
				getConnection().close();
			}
		}
	}
	
	public int applyJob(String job_id, String user_id) throws Exception {

		int i = 0;
		try {
			String sql = "INSERT INTO job_user (job_id, user_id) VALUES (?,?)";
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setString(1, job_id);
			ps.setString(2, user_id);
			i = ps.executeUpdate();
			return i;
		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
			return i;
		} finally {
			if (getConnection()!= null) {
				getConnection().close();
			}
		}
	}
	
	public ResultSet fetchApplicants(String job_id) throws SQLException, Exception {

		ResultSet rs = null;
		try {
			String sql = "SELECT job_user.job_id, job_user.user_id, user.firstname, user.lastname, user.email\r\n" + 
					"FROM `job_user`\r\n" + 
					"LEFT JOIN user\r\n" + 
					"ON job_user.user_id = user.id\r\n" + 
					"WHERE job_user.job_id=?";
					
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setString(1, job_id);
			rs = ps.executeQuery();
			return rs;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			if (getConnection()!= null) {
				getConnection().close();
			}
		}
	}
	
	public int createProject(String project_title, String project_description, String project_requirement,String email) throws Exception {
		
		int i = 0;
		try {
			String sql = "INSERT INTO projects (project_title, project_description, project_requirement, posted_by) VALUES (?,?,?,?)";
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setString(1, project_title);
			ps.setString(2, project_description);
			ps.setString(3, project_requirement);
			ps.setString(4, email);
			i = ps.executeUpdate();
			return i;
		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
			return i;
		} finally {
			if (getConnection()!= null) {
				getConnection().close();
			}
		}
	}

	public ResultSet fetchProjects() throws SQLException, Exception {

		ResultSet rs = null;
		try {
			String sql = "SELECT * FROM projects;";
			PreparedStatement ps = getConnection().prepareStatement(sql);
			rs = ps.executeQuery();
			return rs;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			if (getConnection()!= null) {
				getConnection().close();
			}
		}
	}
}
