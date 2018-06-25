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


import edu.northeastern.cs5200.models.Widget;
import edu.northeastern.cs5200.models.Image;
import edu.northeastern.cs5200.models.Youtube;
import edu.northeastern.cs5200.models.Heading;
import edu.northeastern.cs5200.models.Html;


public class WidgetDao {

	public static WidgetDao instance = null;
	public static WidgetDao getInstance() {
		if(instance == null) {
			instance = new WidgetDao();
		}
		return instance;
	}

	private WidgetDao() {

	}

	public int createWidgetForPage(int pageId, Widget widget) {

		Connection connection = null;
		PreparedStatement statement1 = null;
		PreparedStatement statement2 = null;
		ResultSet results = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost/hw2_ladani_suhani_summer_2018", "root", "root");
			
			String sql1 = "INSERT INTO widget (id, name, width, height, cssClass, cssStyle, text, widget.order, pageId) VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			statement1 = connection.prepareStatement(sql1);
			statement1.setInt(1, widget.getId());
			statement1.setString(2, widget.getName());
			statement1.setInt(3, widget.getWidth());
			statement1.setInt(4, widget.getHeight());
			statement1.setString(5, widget.getCssClass());
			statement1.setString(6, widget.getCssStyle());
			statement1.setString(7, widget.getText());
			statement1.setInt(8, widget.getOrder());	
			statement1.setInt(9, pageId);
			statement1.executeUpdate();
			
			if (widget.getType() instanceof Image) {		
				String sql2 = "INSERT INTO image (widgetId, src) VALUES(?, ?)";	
				statement2 = connection.prepareStatement(sql2);			
				statement2.setInt(1, widget.getId());
				statement2.setString(2, ((Image)widget.getType()).getSrc());
	
				statement2.executeUpdate();

			}
			
			if (widget.getType() instanceof Heading) {		
				String sql2 = "INSERT INTO heading (widgetId, size) VALUES(?, ?)";	
				statement2 = connection.prepareStatement(sql2);			
				statement2.setInt(1, widget.getId());
				statement2.setInt(2, ((Heading) widget.getType()).getSize());
			
				statement2.executeUpdate();

			}
		
			if (widget.getType() instanceof Html) {		
				String sql2 = "INSERT INTO html (widgetId, html) VALUES(?, ?)";	
				statement2 = connection.prepareStatement(sql2);			
				statement2.setInt(1, widget.getId());
				statement2.setString(2, ((Html) widget.getType()).getHtml());
			
				statement2.executeUpdate();

			}
			
			if (widget.getType() instanceof Youtube) {		
				String sql2 = "INSERT INTO youtube (widgetId, url, shareable, expandable) VALUES(?, ?, ?, ?)";	
				statement2 = connection.prepareStatement(sql2);			
				statement2.setInt(1, widget.getId());
				statement2.setString(2, ((Youtube) widget.getType()).getUrl());
				statement2.setBoolean(3, ((Youtube)widget.getType()).isShareable());
				statement2.setBoolean(4, ((Youtube)widget.getType()).isExpandable());
			
				statement2.executeUpdate();

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
		return 0;

	}

	public List<Widget> findAllWidget(){
		List<Widget> widgets = new ArrayList<Widget>();
		Connection connection = null;
		Statement statement = null;
		ResultSet results = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost/hw2_ladani_suhani_summer_2018", "root", "root");
			statement = connection.createStatement();
			String sql = "SELECT * FROM widget LEFT JOIN image ON widget.id=image.widgetId LEFT JOIN html ON widget.id = html.widgetId LEFT JOIN heading ON widget.id=heading.widgetId LEFT JOIN youtube ON widget.id = youtube.widgetId";
			results = statement.executeQuery(sql);
			while(results.next()) {
				int id = results.getInt("id");
				String name = results.getString("name");
				int width = results.getInt("width");
				int height = results.getInt("height");
				String cssClass = results.getString("cssClass");
				String cssStyle = results.getString("cssStyle");
				String text = results.getString("text");
				int order = results.getInt("order");
				String src = results.getString("src");
				String url = results.getString("url");
				boolean shareable = results.getBoolean("shareable");
				boolean expandable = results.getBoolean("expandable");
				int size = results.getInt("size");
				String html = results.getString("html");
				int pageId = results.getInt("pageId");
				Widget widget = new Widget(id, name, width, height, cssClass, cssStyle, text, order, src, url, shareable, expandable, size, html, pageId);
				widgets.add(widget);
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

		return widgets;

	}

	public Widget findWidgetById(int widgetId) {


		Widget widget = null;
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet results = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost/hw2_ladani_suhani_summer_2018", "root", "root");
			String sql = "SELECT * FROM widget LEFT JOIN image ON widget.id=image.widgetId LEFT JOIN html ON widget.id = html.widgetId LEFT JOIN heading ON widget.id=heading.widgetId LEFT JOIN youtube ON widget.id = youtube.widgetId WHERE id= ?";
			statement = connection.prepareStatement(sql);
			statement.setInt(1, widgetId);
			results = statement.executeQuery();
			if(results.next()) {
				int id = results.getInt("id");
				String name = results.getString("name");
				int width = results.getInt("width");
				int height = results.getInt("height");
				String cssClass = results.getString("cssClass");
				String cssStyle = results.getString("cssStyle");
				String text = results.getString("text");
				int order = results.getInt("order");
				String src = results.getString("src");
				String url = results.getString("url");
				boolean shareable = results.getBoolean("shareable");
				boolean expandable = results.getBoolean("expandable");
				int size = results.getInt("size");
				String html = results.getString("html");
				int pageId = results.getInt("pageId");
				widget = new Widget(id, name, width, height, cssClass, cssStyle, text, order, src, url, shareable, expandable, size, html, pageId);

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

		return widget;

	}

	public List<Widget> findWidgetForPage(int pageId){
		List<Widget> widgets = new ArrayList<Widget>();
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet results = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost/hw2_ladani_suhani_summer_2018", "root", "root");

			String sql = "SELECT * FROM widget LEFT JOIN image ON widget.id=image.widgetId LEFT JOIN html ON widget.id = html.widgetId LEFT JOIN heading ON widget.id=heading.widgetId LEFT JOIN youtube ON widget.id = youtube.widgetId WHERE pageId= ?";
			statement = connection.prepareStatement(sql);
			statement.setInt(1, pageId);
			results = statement.executeQuery();
			while(results.next()) {
				int id = results.getInt("id");
				String name = results.getString("name");
				int width = results.getInt("width");
				int height = results.getInt("height");
				String cssClass = results.getString("cssClass");
				String cssStyle = results.getString("cssStyle");
				String text = results.getString("text");
				int order = results.getInt("order");
				String src = results.getString("src");
				String url = results.getString("url");
				boolean shareable = results.getBoolean("shareable");
				boolean expandable = results.getBoolean("expandable");
				int size = results.getInt("size");
				String html = results.getString("html");
				int pageId1 = results.getInt("pageId");
				Widget widget = new Widget(id, name, width, height, cssClass, cssStyle, text, order, src, url, shareable, expandable, size, html, pageId1);
				widgets.add(widget);
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

		return widgets;

	}

	public int updateWidget(int widgetId, Widget widget) {

		Connection connection = null;
		PreparedStatement statement = null;
		PreparedStatement statement2 = null;
		ResultSet results = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost/hw2_ladani_suhani_summer_2018", "root", "root");

			String sql = "UPDATE widget SET id=?, name=?, width=?, height=?, cssClass=?, cssStyle=?, text=?, widget.order=? WHERE id = ?";   

			statement = connection.prepareStatement(sql);

			statement.setInt(1, widget.getId());
			statement.setString(2, widget.getName());
			statement.setInt(3, widget.getWidth());
			statement.setInt(4, widget.getHeight());
			statement.setString(5, widget.getCssClass());
			statement.setString(6, widget.getCssStyle());
			statement.setString(7, widget.getText());
			statement.setInt(8, widget.getOrder());
			statement.setInt(9, widgetId);	
			statement.executeUpdate();
			
			
			if (widget.getType() instanceof Image) {		
				String sql2 = "UPDATE image SET widgetId=?, src=?";	
				statement2 = connection.prepareStatement(sql2);			
				statement2.setInt(1, widget.getId());
				statement2.setString(2, ((Image)widget).getSrc());
	
				statement2.executeUpdate();

			}
			
			if (widget.getType() instanceof Heading) {		
				String sql2 = "UPDATE heading SET widgetId=?, size=?";	
				statement2 = connection.prepareStatement(sql2);			
				statement2.setInt(1, widget.getId());
				statement2.setInt(2, ((Heading) widget.getType()).getSize());
			
				statement2.executeUpdate();

			}
		
			if (widget.getType() instanceof Html) {		
				String sql2 = "UPDATE heading SET widgetId=?, html=?";	
				statement2 = connection.prepareStatement(sql2);			
				statement2.setInt(1, widget.getId());
				statement2.setString(2, ((Html) widget.getType()).getHtml());
			
				statement2.executeUpdate();

			}
			
			if (widget.getType() instanceof Youtube) {		
				String sql2 = "UPDATE heading SET widgetId=?, url=?, shareable=?, expandable=?";	
				statement2 = connection.prepareStatement(sql2);			
				statement2.setInt(1, widget.getId());
				statement2.setString(2, ((Youtube) widget.getType()).getUrl());
				statement2.setBoolean(3, ((Youtube)widget.getType()).isShareable());
				statement2.setBoolean(3, ((Youtube)widget.getType()).isExpandable());
				statement2.executeUpdate();

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
		return -1;

	}

	public int deleteWidget(int widgetId) {

		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet results = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost/hw2_ladani_suhani_summer_2018", "root", "root");
			String sql = "DELETE FROM widget WHERE id = ?";
			statement = connection.prepareStatement(sql);
			statement.setInt(1, widgetId);
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
