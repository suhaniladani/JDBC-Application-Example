package edu.northeastern.cs5200.Dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import edu.northeastern.cs5200.models.Developer;
import edu.northeastern.cs5200.models.Website;


public class WebsiteDao {
	
	public static WebsiteDao instance = null;
	public static WebsiteDao getInstance() {
		if(instance == null) {
			instance = new WebsiteDao();
		}
		return instance;
	}
	
	private WebsiteDao() {
		
	}
	
	public List<Website> findAllWebsites(){
		List<Website> websites = new ArrayList<Website>();
		Connection connection = null;
		Statement statement = null;
		ResultSet results = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost/hw2_ladani_suhani_summer_2018", "root", "root");
			statement = connection.createStatement();
			String sql = "SELECT * FROM website";
			results = statement.executeQuery(sql);
			while(results.next()) {
				int id = results.getInt("id");
				String name = results.getString("name");
				String description = results.getString("description");
				Date created = results.getDate("created");
				Date updated = results.getDate("updated");
				int visitis = results.getInt("visits");
				int developerId = results.getInt("developerId");
				Website website = new Website(id, name, description, created, updated, visitis);
				websites.add(website);
			}
		
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
		
		return websites;
		
	}
	
	public int createWebsiteForDeveloper(int developerId, Website website) {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet results = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost/hw2_ladani_suhani_summer_2018", "root", "root");
			String sql = "INSERT INTO website (id, name, description, created, updated, visits, developerId) VALUES (?, ?, ?, ?, ?, ?, ?)";
			
			statement = connection.prepareStatement(sql);
			statement.setInt(1, website.getId());
			statement.setString(2, website.getName());
			statement.setString(3, website.getDescription());
			statement.setDate(4, website.getCreated());
			statement.setDate(5, website.getUpdated());
			statement.setInt(6, website.getVisits());
			statement.setInt(7, developerId);
			
			
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
		return 0;
		
	}
	
	public List<Website> findWebsitesForDeveloper(int developerId){
		List<Website> websites = new ArrayList<Website>();
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet results = null;
				
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost/hw2_ladani_suhani_summer_2018", "root", "root");
			
			String sql = "SELECT * FROM website where developerId=?";
			statement = connection.prepareStatement(sql);
			statement.setInt(1, developerId);
			results = statement.executeQuery();
			while(results.next()) {
				int id = results.getInt("id");
				String name = results.getString("name");
				String description = results.getString("description");
				Date created = results.getDate("created");
				Date updated = results.getDate("updated");
				int visitis = results.getInt("visits");
				Website website = new Website(id, name, description, created, updated, visitis);
				websites.add(website);
			}
		
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
		
		return websites;
		
	}
	
	public Website findWebsiteById(int websiteId) {
		
		
		Website website = null;
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet results = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost/hw2_ladani_suhani_summer_2018", "root", "root");
			String sql = "SELECT * FROM website WHERE id= ?";
			statement = connection.prepareStatement(sql);
			statement.setInt(1, websiteId);
			results = statement.executeQuery();
			if(results.next()) {
				int id = results.getInt("id");
				String name = results.getString("name");
				String description = results.getString("description");
				Date created = results.getDate("created");
				Date updated = results.getDate("updated");
				int visitis = results.getInt("visits");
				website = new Website(id, name, description, created, updated, visitis);
		
			}
		
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
		
		return website;
		
	}
	
	public int updateWebsite(int websiteId, Website website) {
		
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet results = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost/hw2_ladani_suhani_summer_2018", "root", "root");
			
			String sql = "UPDATE website SET id = ? , name=? , description =? , created =?, updated=?, visits=? WHERE id = ?";   

			statement = connection.prepareStatement(sql);

			statement.setInt(1, website.getId());
			statement.setString(2, website.getName());
			statement.setString(3, website.getDescription());
			statement.setDate(4, website.getCreated());
			statement.setDate(5, website.getUpdated());
			statement.setInt(6, website.getVisits());
			statement.setInt(7, websiteId);
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
	
	public int deleteWebsite(int websiteId) {
		
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet results = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost/hw2_ladani_suhani_summer_2018", "root", "root");
			String sql = "DELETE FROM website WHERE id = ?";
			statement = connection.prepareStatement(sql);
			statement.setInt(1, websiteId);
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

}
