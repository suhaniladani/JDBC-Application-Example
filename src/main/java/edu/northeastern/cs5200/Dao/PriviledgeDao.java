package edu.northeastern.cs5200.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PriviledgeDao {
	

		public static PriviledgeDao instance = null;
		public static PriviledgeDao getInstance() {
			if(instance == null) {
				instance = new PriviledgeDao();
			}
			return instance;
		}

		private PriviledgeDao() {

		}


		public int assignWebsitePriviledge(int developerId, int websiteId, int priviledgeId) {
			Connection connection = null;
			PreparedStatement statement = null;
			ResultSet results = null;

			try {
				Class.forName("com.mysql.jdbc.Driver");
				connection = DriverManager.getConnection("jdbc:mysql://localhost/hw2_ladani_suhani_summer_2018", "root", "root");
				String sql = "INSERT INTO websitePriviledge (developerId, websiteId, priviledgeId) VALUES (?, ?, ?)";

				statement = connection.prepareStatement(sql);
				statement.setInt(1,developerId);
				statement.setInt(2,websiteId);
				statement.setInt(3, priviledgeId);



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

		public void assignPagePriviledge(int developerId, int pageId, int priviledgeId) {
			
			Connection connection = null;
			PreparedStatement statement = null;


			try {
				Class.forName("com.mysql.jdbc.Driver");
				connection = DriverManager.getConnection("jdbc:mysql://localhost/hw2_ladani_suhani_summer_2018", "root", "root");
				String sql = "INSERT INTO pagePriviledge (developerId, pageId, priviledgeId) VALUES (?, ?, ?)";

				statement = connection.prepareStatement(sql);
				statement.setInt(1,developerId);
				statement.setInt(2,pageId);
				statement.setInt(3, priviledgeId);



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
		
		public void deleteWebsitePriviledge(int developerId, int websiteId, int priviledgeId) {
			Connection connection = null;
			PreparedStatement statement = null;

			
			try {
				Class.forName("com.mysql.jdbc.Driver");
				connection = DriverManager.getConnection("jdbc:mysql://localhost/hw2_ladani_suhani_summer_2018", "root", "root");
				String sql = "DELETE FROM websitePriviledge WHERE developerId = ?, websiteId=?, priviledgeId =?";
				statement = connection.prepareStatement(sql);
				statement.setInt(1, developerId);
				statement.setInt(2, websiteId);
				statement.setInt(3, priviledgeId);
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
		
		public void deletePagePriviledge(int developerId, int pageId, int priviledgeId) {
			Connection connection = null;
			PreparedStatement statement = null;

			
			try {
				Class.forName("com.mysql.jdbc.Driver");
				connection = DriverManager.getConnection("jdbc:mysql://localhost/hw2_ladani_suhani_summer_2018", "root", "root");
				String sql = "DELETE FROM pagePriviledge WHERE developerId = ?, pageId=?, priviledgeId =?";
				statement = connection.prepareStatement(sql);
				statement.setInt(1, developerId);
				statement.setInt(2, pageId);
				statement.setInt(3, priviledgeId);
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
