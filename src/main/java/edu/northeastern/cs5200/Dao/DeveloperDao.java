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


public class DeveloperDao {
	
	public static DeveloperDao instance = null;
	public static DeveloperDao getInstance() {
		if(instance == null) {
			instance = new DeveloperDao();
		}
		return instance;
	}
	
	private DeveloperDao() {
		
	}
	
	public List<Developer> findAllDevelopers(){
		List<Developer> developers = new ArrayList<Developer>();
		Connection connection = null;
		Statement statement = null;
		ResultSet results = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost/hw2_ladani_suhani_summer_2018", "root", "root");
			statement = connection.createStatement();
			String sql = "SELECT * FROM person AS p inner join developer AS d ON p.id = d.developerId";
			results = statement.executeQuery(sql);
			while(results.next()) {
				String firstName = results.getString("firstName");
				String lastName = results.getString("lastName");
				String username = results.getString("username");
				String password = results.getString("password");
				String email = results.getString("email");
				Date dob = results.getDate("dob");
				String developerKey = results.getString("developerKey");
				int developerId = results.getInt("developerId");
				Developer developer = new Developer(developerId, firstName, lastName, username, password, email, dob, developerKey);
				developers.add(developer);
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
		
		return developers;
		
	}
	
	public int createDeveloper(Developer developer) {
		Connection connection = null;
		PreparedStatement statement1 = null;
		PreparedStatement statement2 = null;
		ResultSet results = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost/hw2_ladani_suhani_summer_2018", "root", "root");
			String sql1 = "INSERT INTO person (id, firstName, lastName, username, password, email, dob) VALUES (?, ?, ?, ?, ?, ?, ?)";
			String sql2 = "INSERT INTO developer (developerId, developerKey) VALUES (?, ?)";
			
			statement1 = connection.prepareStatement(sql1);
			statement2 = connection.prepareStatement(sql2);
			statement1.setInt(1, developer.getId());
			statement1.setString(2, developer.getFirstName());
			statement1.setString(3, developer.getLastName());
			statement1.setString(4, developer.getUsername());
			statement1.setString(5, developer.getPassword());
			statement1.setString(6, developer.getEmail());
			statement1.setDate(7, developer.getDob());
			statement2.setInt(1, developer.getId());
			statement2.setString(2, developer.getDeveloperKey());
			
			
			System.out.println(sql1);
			statement1.executeUpdate();
			statement2.executeUpdate();

		
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
	
public Developer findDeveloperById(int developerId) {
		
		Developer developer = null;
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet results = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost/hw2_ladani_suhani_summer_2018", "root", "root");
			String sql = "SELECT * FROM person AS p inner join developer AS d ON p.id = d.developerId WHERE developerId= ?";
			statement = connection.prepareStatement(sql);
			statement.setInt(1, developerId);
			results = statement.executeQuery();
			if(results.next()) {
				String firstName = results.getString("firstName");
				String lastName = results.getString("lastName");
				String username = results.getString("username");
				String password = results.getString("password");
				String email = results.getString("email");
				Date dob = results.getDate("dob");
				String developerKey = results.getString("developerKey");
				int developerId1 = results.getInt("developerId");
				developer = new Developer(developerId1, firstName, lastName, username, password, email, dob, developerKey);
		
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
		
		return developer;
	}

public Developer findDeveloperByUsername(String username) {
	
	Developer developer = null;
	Connection connection = null;
	PreparedStatement statement = null;
	ResultSet results = null;
	
	try {
		Class.forName("com.mysql.jdbc.Driver");
		connection = DriverManager.getConnection("jdbc:mysql://localhost/hw2_ladani_suhani_summer_2018", "root", "root");
		String sql = "SELECT * FROM person AS p inner join developer AS d ON p.id = d.developerId WHERE p.username= ?";
		statement = connection.prepareStatement(sql);
		statement.setString(1, username);
		results = statement.executeQuery();
		if(results.next()) {
			String firstName = results.getString("firstName");
			String lastName = results.getString("lastName");
			String username1 = results.getString("username");
			String password = results.getString("password");
			String email = results.getString("email");
			Date dob = results.getDate("dob");
			String developerKey = results.getString("developerKey");
			int developerId = results.getInt("developerId");
			developer = new Developer(developerId, firstName, lastName, username1, password, email, dob, developerKey);
	
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
	
	return developer;
}


public Developer findDeveloperByCredentials(String username, String password) {
	
	Developer developer = null;
	Connection connection = null;
	PreparedStatement statement = null;
	ResultSet results = null;
	
	try {
		Class.forName("com.mysql.jdbc.Driver");
		connection = DriverManager.getConnection("jdbc:mysql://localhost/hw2_ladani_suhani_summer_2018", "root", "root");
		String sql = "SELECT * FROM person AS p inner join developer AS d ON p.id = d.developerId WHERE p.username= ? AND p.password=?";
		statement = connection.prepareStatement(sql);
		statement.setString(1, username);
		statement.setString(2, password);
		results = statement.executeQuery();
		if(results.next()) {
			String firstName = results.getString("firstName");
			String lastName = results.getString("lastName");
			String username1 = results.getString("username");
			String password1 = results.getString("password");
			String email = results.getString("email");
			Date dob = results.getDate("dob");
			String developerKey = results.getString("developerKey");
			int developerId = results.getInt("developerId");
			developer = new Developer(developerId, firstName, lastName, username1, password1, email, dob, developerKey);
	
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
	
	return developer;
}

public int updateDeveloper(int developerId, Developer developer) {
	
	Connection connection = null;
	PreparedStatement statement1 = null;
	PreparedStatement statement2 = null;
	ResultSet results = null;
	
	try {
		Class.forName("com.mysql.jdbc.Driver");
		connection = DriverManager.getConnection("jdbc:mysql://localhost/hw2_ladani_suhani_summer_2018", "root", "root");
		
		String sql1 = "UPDATE person SET id = ? , firstName=? , lastName =? , username =?, password=?, email=?, dob=? WHERE id = ?";   
		String sql2 = "UPDATE developer SET developerId = ?, developerKey=? WHERE developerId = ?";   
		statement1 = connection.prepareStatement(sql1);
		statement2 = connection.prepareStatement(sql2);
		statement1.setInt(1, developer.getId());
		statement1.setString(2, developer.getFirstName());
		statement1.setString(3, developer.getLastName());
		statement1.setString(4, developer.getUsername());
		statement1.setString(5, developer.getPassword());
		statement1.setString(6, developer.getEmail());
		statement1.setDate(7, developer.getDob());
		statement1.setInt(8, developerId);
		statement2.setInt(1, developer.getId());
		statement2.setString(2, developer.getDeveloperKey());
		statement2.setInt(3, developerId);
		statement1.executeUpdate();
		statement2.executeUpdate();

	
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

public int deleteDeveloper(int developerId) {
	
	Connection connection = null;
	PreparedStatement statement = null;
	ResultSet results = null;
	
	try {
		Class.forName("com.mysql.jdbc.Driver");
		connection = DriverManager.getConnection("jdbc:mysql://localhost/hw2_ladani_suhani_summer_2018", "root", "root");
		String sql = "DELETE d, p FROM developer AS d INNER JOIN person AS p ON d.developerId = p.id WHERE d.developerId = ?";
		
		statement = connection.prepareStatement(sql);
		statement.setInt(1, developerId);
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
