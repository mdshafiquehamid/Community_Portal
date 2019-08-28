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
 * @description UserHome class contains the MySQL functionalities for User post-login.
 */


public class UserHome implements CommonMethod {
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
	
	public ResultSet fetchUserDetails(String email) throws SQLException, Exception {
		ResultSet rs = null;
		try {
			String sql = "SELECT * FROM `user` LEFT JOIN address ON user.id = address.id WHERE email=?";
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

	public ResultSet fetchSearchedUsers(String searchquery) throws SQLException, Exception {
		ResultSet rs = null;
		try {
			String sql = "SELECT * FROM `user` LEFT JOIN address ON user.id = address.id "
					+ "WHERE firstname=? OR lastname=? "
					+ "OR company=? OR city=? OR country=?";
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setString(1, searchquery);
			ps.setString(2, searchquery);
			ps.setString(3, searchquery);
			ps.setString(4, searchquery);
			ps.setString(5, searchquery);
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
	
	public ResultSet fetchQualifications(String email) throws SQLException, Exception {
		ResultSet rs = null;
		try {
			String sql = "SELECT * FROM `user` LEFT JOIN qualifications ON user.id = qualifications.id WHERE email=?";
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
	
	public ResultSet fetchExperiences(String email) throws SQLException, Exception {
		ResultSet rs = null;
		try {
			String sql = "SELECT user.id, user.email, experiences.company, experiences.country, "
					+ "experiences.description, experiences.duration, experiences.id, experiences.experience_id, experiences.work_position "
					+ "FROM `user` LEFT JOIN experiences ON user.id = experiences.id "
					+ "WHERE email=?";
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
	
	public ResultSet fetchSkills(String email) throws SQLException, Exception {
		ResultSet rs = null;
		try {
			String sql = "SELECT * FROM `user` LEFT JOIN skills ON user.id = skills.id WHERE email=?";
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
	
	public int updateUserDetails(String firstname, String lastname, String email, String position, 
			String company, String country, String city, String emailhidden) throws SQLException, Exception {
		getConnection().setAutoCommit(false);
		int i = 0;
		try {
			String sql = "UPDATE user LEFT JOIN address ON user.id = address.id\r\n" + 
					"SET user.firstname=?, user.lastname=?, user.email=?, user.position=?, user.company=?,"
					+ "address.country=?, address.city=? " + 
					"WHERE email=?;";
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setString(1, firstname);
			ps.setString(2, lastname);
			ps.setString(3, email);
			ps.setString(4, position);
			ps.setString(5, company);
			ps.setString(6, country);
			ps.setString(7, city);
			ps.setString(8, emailhidden);
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
	
	public ResultSet fetchSpecificQualification(String email, String id) throws SQLException, Exception {
		ResultSet rs = null;
		try {
			String sql = "SELECT * FROM `user` LEFT JOIN qualifications ON user.id = qualifications.id WHERE email=? AND qualifications.qualification_id=?";
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setString(1, email);
			ps.setString(2, id);
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
	
	public int updateQualifications(String qualification_type, String qualification_cert, String qualification_description, String qualification_id, String email) throws SQLException, Exception {
		getConnection().setAutoCommit(false);
		int i = 0;
		try {
			String sql = "UPDATE user LEFT JOIN qualifications ON user.id = qualifications.id\r\n" + 
					"	SET qualifications.qualification_type=?, qualifications.qualification=?, qualifications.description=?\r\n" + 
					"	WHERE user.email=? AND qualifications.qualification_id=?;";
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setString(1, qualification_type);
			ps.setString(2, qualification_cert);
			ps.setString(3, qualification_description);
			ps.setString(4, email);
			ps.setString(5, qualification_id);
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
	
	public int createQualification(String qualification_type, String qualification_cert, String qualification_description,String id) throws Exception {
		int i = 0;
		try {
			String sql = "INSERT INTO qualifications (qualification_type, qualification, description, id) VALUES (?,?,?,?)";
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setString(1, qualification_type);
			ps.setString(2, qualification_cert);
			ps.setString(3, qualification_description);
			ps.setString(4, id);
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
	
	public ResultSet fetchSpecificExperience(String email, String id) throws SQLException, Exception {
		ResultSet rs = null;
		try {
			String sql = "SELECT experiences.experience_id, experiences.company, experiences.work_position,"
					+ "experiences.duration, experiences.country, experiences.description "
					+ "FROM `user` LEFT JOIN experiences ON user.id = experiences.id "
					+ "WHERE email=? AND experiences.experience_id=?";
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setString(1, email);
			ps.setString(2, id);
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
	
	public int updateExperiences(String experience_company,String experience_position,String duration,String experience_country,String experience_description,String experience_id,String email) throws SQLException, Exception {
		getConnection().setAutoCommit(false);
		int i = 0;
		try {
			String sql = "UPDATE user LEFT JOIN experiences ON user.id = experiences.id\r\n" + 
					"	SET experiences.company=?, experiences.work_position=?, experiences.duration=?, "
					+ "experiences.country=?,experiences.description=? " + 
					"	WHERE user.email=? AND experiences.experience_id=?;";
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setString(1, experience_company);
			ps.setString(2, experience_position);
			ps.setString(3, duration);
			ps.setString(4, experience_country);
			ps.setString(5, experience_description);
			ps.setString(6, email);
			ps.setString(7, experience_id);
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
	
	public int createExperience(String experience_company, String experience_position, String duration,String experience_country,String experience_description, String id) throws Exception {
		int i = 0;
		try {
			String sql = "INSERT INTO experiences (company, work_position, duration, country, description, id) VALUES (?,?,?,?,?,?)";
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setString(1, experience_company);
			ps.setString(2, experience_position);
			ps.setString(3, duration);
			ps.setString(4, experience_country);
			ps.setString(5, experience_description);
			ps.setString(6, id);
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
	
	public int createSkill(String skill, String id) throws Exception {
		int i = 0;
		try {
			String sql = "INSERT INTO skills (skill, id) VALUES (?,?)";
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setString(1, skill);
			ps.setString(2, id);
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
	
	public int deleteQualification(String id) throws SQLException, Exception {
		getConnection().setAutoCommit(false);
		int i = 0;
		try {
			String sql = "DELETE FROM qualifications WHERE qualification_id=?";
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setString(1, id);
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
	
	public int deleteExperience(String id) throws SQLException, Exception {
		getConnection().setAutoCommit(false);
		int i = 0;
		try {
			String sql = "DELETE FROM experiences WHERE experience_id=?";
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setString(1, id);
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
	
	public int deleteSkill(String id) throws SQLException, Exception {
		getConnection().setAutoCommit(false);
		int i = 0;
		try {
			String sql = "DELETE FROM skills WHERE skill_id=?";
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setString(1, id);
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
	
	public ResultSet fetchThreads() throws SQLException, Exception {

		ResultSet rs = null;
		try {
			String sql = "SELECT thread.thread_id, thread.thread_title, thread.posted_on, user.firstname, user.lastname FROM `thread`\r\n" + 
					"LEFT JOIN user\r\n" + 
					"ON thread.posted_by = user.id\r\n" + 
					"ORDER BY thread.posted_on DESC;";
			
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
	
	public int createThread(String thread_message, String user_id) throws Exception {
		int i = 0;
		try {
			String sql = "INSERT INTO thread (thread_title, posted_by) VALUES (?,?)";
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setString(1, thread_message);
			ps.setString(2, user_id);
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
	
	public ResultSet fetchThread(String thread_id) throws SQLException, Exception {

		ResultSet rs = null;
		try {
			String sql = "SELECT thread.thread_id, thread.thread_title, thread.posted_on, user.firstname, user.lastname FROM `thread`\r\n" + 
					"LEFT JOIN user\r\n" + 
					"ON thread.posted_by = user.id\r\n" + 
					"WHERE thread.thread_id=?;\r\n" + 
					"";
			
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setString(1, thread_id);
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
	
	public ResultSet fetchReplies(String thread_id) throws SQLException, Exception {

		ResultSet rs = null;
		try {
			String sql = "SELECT * FROM thread_replies LEFT JOIN user "
					+ "ON thread_replies.posted_by = user.id WHERE "
					+ "thread_replies.thread_id=? "
					+ "ORDER BY thread_replies.posted_on DESC;";

			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setString(1, thread_id);
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
	
	public int replyThread(String thread_id, String thread_message, String user_id) throws Exception {
		int i = 0;
		try {
			String sql = "INSERT INTO thread_replies (thread_id, thread_reply, posted_by) VALUES (?,?,?)";
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setString(1, thread_id);
			ps.setString(2, thread_message);
			ps.setString(3, user_id);
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
	
	public int message(String message, String user_id, String recipient_id, String user_email) throws Exception {
		int i = 0;
		try {
			String sql = "INSERT INTO messages (message, user_id, recipient_id, user_email) VALUES (?,?,?,?)";
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setString(1, message);
			ps.setString(2, user_id);
			ps.setString(3, recipient_id);
			ps.setString(4, user_email);
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
	
	public ResultSet fetchMessages(String user_id, String recipient_id) throws SQLException, Exception {

		ResultSet rs = null;
		try {
			String sql = "SELECT messages.message_id, messages.message,messages.user_id, "
					+ "messages.recipient_id, messages.sent_on, messages.user_email, user.firstname, user.lastname "
					+ "FROM `messages` LEFT JOIN user ON messages.user_id = user.id "
					+ "WHERE messages.user_id = ? AND messages.recipient_id = ? "
					+ "OR messages.user_id = ? "
					+ "AND messages.recipient_id = ? "
					+ "ORDER BY messages.sent_on ASC;";

			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setString(1, user_id);
			ps.setString(2, recipient_id);
			ps.setString(3, recipient_id);
			ps.setString(4, user_id);
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
