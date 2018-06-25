package edu.northeastern.cs5200.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RoleDao {

	public static RoleDao instance = null;
	public static RoleDao getInstance() {
		if(instance == null) {
			instance = new RoleDao();
		}
		return instance;
	}

	private RoleDao() {

	}


	public int assignWebsiteRole(int developerId, int websiteId, int roleId) {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet results = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost/hw2_ladani_suhani_summer_2018", "root", "root");
			String sql = "INSERT INTO websiteRole (developerId, websiteId, roleId) VALUES (?, ?, ?)";

			statement = connection.prepareStatement(sql);
			statement.setInt(1,developerId);
			statement.setInt(2,websiteId);
			statement.setInt(3, roleId);



			System.out.println(sql);
			statement.executeUpdate();


		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return -1;

	}

	public void assignPageRole(int developerId, int pageId, int roleId) {
		
		Connection connection = null;
		PreparedStatement statement = null;


		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost/hw2_ladani_suhani_summer_2018", "root", "root");
			String sql = "INSERT INTO pageRole (developerId, pageId, roleId) VALUES (?, ?, ?)";

			statement = connection.prepareStatement(sql);
			statement.setInt(1,developerId);
			statement.setInt(2,pageId);
			statement.setInt(3, roleId);



			System.out.println(sql);
			statement.executeUpdate();


		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
	
	public void deleteWebsiteRole(int developerId, int websiteId, int roleId) {
		Connection connection = null;
		PreparedStatement statement = null;

		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost/hw2_ladani_suhani_summer_2018", "root", "root");
			String sql = "DELETE FROM websiteRole WHERE developerId = ?, websiteId=?, roleId =?";
			statement = connection.prepareStatement(sql);
			statement.setInt(1, developerId);
			statement.setInt(2, websiteId);
			statement.setInt(3, roleId);
			System.out.println(sql);
			statement.executeUpdate();

		
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	
	}
	
	public void deletePageRole(int developerId, int pageId, int roleId) {
		Connection connection = null;
		PreparedStatement statement = null;

		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost/hw2_ladani_suhani_summer_2018", "root", "root");
			String sql = "DELETE FROM pageRole WHERE developerId = ?, pageId=?, roleId =?";
			statement = connection.prepareStatement(sql);
			statement.setInt(1, developerId);
			statement.setInt(2, pageId);
			statement.setInt(3, roleId);
			System.out.println(sql);
			statement.executeUpdate();

		
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	
	}

}
