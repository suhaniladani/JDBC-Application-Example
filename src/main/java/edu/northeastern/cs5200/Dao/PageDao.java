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

import edu.northeastern.cs5200.models.Page;



public class PageDao {
	
	public static PageDao instance = null;
	public static PageDao getInstance() {
		if(instance == null) {
			instance = new PageDao();
		}
		return instance;
	}
	
	public int createPageForWebsite(int websiteId, Page page) {
		Connection connection = null;
		PreparedStatement statement = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost/hw2_ladani_suhani_summer_2018", "root", "root");
			String sql = "INSERT INTO page (id, title, description, created, updated, views, websiteId) VALUES (?, ?, ?, ?, ?, ?, ?)";
			
			statement = connection.prepareStatement(sql);
			statement.setInt(1, page.getId());
			statement.setString(2, page.getTitle());
			statement.setString(3, page.getDescription());
			statement.setDate(4, page.getCreated());
			statement.setDate(5, page.getUpdated());
			statement.setInt(6, page.getViews());
			statement.setInt(7, websiteId);


			
			
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
	
	public List<Page> findAllPages(){
		List<Page> pages = new ArrayList<Page>();
		Connection connection = null;
		Statement statement = null;
		ResultSet results = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost/hw2_ladani_suhani_summer_2018", "root", "root");
			statement = connection.createStatement();
			String sql = "SELECT * FROM page";
			results = statement.executeQuery(sql);
			while(results.next()) {
				int id = results.getInt("id");
				String title = results.getString("title");
				String description = results.getString("description");
				Date created = results.getDate("created");
				Date updated = results.getDate("updated");
				int views = results.getInt("views");
				int websiteId = results.getInt("websiteId");
				Page page = new Page(id, title, description, created, updated, views);
				pages.add(page);
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
		
		return pages;
		
	}
	
	public Page findPageById(int pageId) {
		
		
		Page page = null;
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet results = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost/hw2_ladani_suhani_summer_2018", "root", "root");
			String sql = "SELECT * FROM page WHERE id= ?";
			statement = connection.prepareStatement(sql);
			statement.setInt(1, pageId);
			results = statement.executeQuery();
			if(results.next()) {
				int id = results.getInt("id");
				String title = results.getString("title");
				String description = results.getString("description");
				Date created = results.getDate("created");
				Date updated = results.getDate("updated");
				int views = results.getInt("views");
				int websiteId = results.getInt("websiteId");
				page = new Page(id, title, description, created, updated, views);
		
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
		
		return page;
		
	}
	
	public List<Page> findPagesForWebsite(int websiteId){
		List<Page> pages = new ArrayList<Page>();
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet results = null;
				
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost/hw2_ladani_suhani_summer_2018", "root", "root");
			
			String sql = "SELECT * FROM page where websiteId=?";
			statement = connection.prepareStatement(sql);
			statement.setInt(1, websiteId);
			results = statement.executeQuery();
			while(results.next()) {
				int id = results.getInt("id");
				String title = results.getString("title");
				String description = results.getString("description");
				Date created = results.getDate("created");
				Date updated = results.getDate("updated");
				int views = results.getInt("views");
				Page page = new Page(id, title, description, created, updated, views);
				pages.add(page);
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
		
		return pages;
		
	}
	
public int updatePage(int pageId, Page page) {
		
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet results = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost/hw2_ladani_suhani_summer_2018", "root", "root");
			
			String sql = "UPDATE website SET id = ? , name=? , description =? , created =?, updated=?, views=? WHERE id = ?";   

			statement = connection.prepareStatement(sql);

			statement.setInt(1, page.getId());
			statement.setString(2, page.getTitle());
			statement.setString(3, page.getDescription());
			statement.setDate(4, page.getCreated());
			statement.setDate(5, page.getUpdated());
			statement.setInt(6, page.getViews());
			statement.setInt(7, pageId);
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

public int deletePage(int pageId) {
	
	Connection connection = null;
	PreparedStatement statement = null;
	ResultSet results = null;
	
	try {
		Class.forName("com.mysql.jdbc.Driver");
		connection = DriverManager.getConnection("jdbc:mysql://localhost/hw2_ladani_suhani_summer_2018", "root", "root");
		String sql = "DELETE FROM page WHERE id = ?";
		statement = connection.prepareStatement(sql);
		statement.setInt(1, pageId);
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
