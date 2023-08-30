package week06;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class DatabaseHandler {

	public static Connection connection = null;
	public static String dbDriver, dbURL, dbUsername, dbPassword;
	
	public static void initialise() throws Exception {
		String propFile = "application.properties";
		Properties appProp = new Properties();
		appProp.load(new FileInputStream(propFile));
		dbDriver = appProp.getProperty("db_driver");
		dbURL = appProp.getProperty("db_url");
		dbUsername = appProp.getProperty("db_username");
		dbPassword = appProp.getProperty("db_password");
	}
	
	public static void connect() throws Exception {
		Class.forName(dbDriver);
		connection = DriverManager
				.getConnection(dbURL, dbUsername, dbPassword);
	}
	
	public static void closeConnection() throws Exception {
		if(connection != null) {
			connection.close();
			connection = null;
		}
	}
	
	public static boolean login(String username, String password) throws Exception {
		connect();
		String sql = 
				"SELECT * FROM users WHERE username=?"
				+ "AND password=SHA2(?,256)";
		PreparedStatement ps = connection.prepareStatement(sql);
		ps.setString(1, username);
		ps.setString(2, password);
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			return true;
		} else {
			return false;
		}
	}
	
	public static void register(String username, String password) throws Exception {
		connect();
		String sql = "INSERT INTO users (username, password) VALUES (?, SHA2(?, 256))";
		PreparedStatement ps = connection.prepareStatement(sql);
		ps.setString(1, username);
		ps.setString(2, password);
		ps.executeUpdate();
	}
	
	public static ResultSet getTodos(String username) throws Exception {
		connect();
		String sql = "SELECT * FROM todos WHERE username=?";
		PreparedStatement ps = connection.prepareStatement(sql);
		ps.setString(1, username);
		ResultSet rs = ps.executeQuery();
		return rs;
	}
	
	public static int addTodo(String username, String toDoText) throws Exception {
		connect();
		String sql = "INSERT INTO todos(username, todo) VALUES (?, ?)";
		PreparedStatement ps = connection
			.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
		ps.setString(1, username);
		ps.setString(2, toDoText);
		ps.executeUpdate();
		ResultSet rs = ps.getGeneratedKeys();
		if(rs.next()) {
			return rs.getInt(1);
		} else {
			return -1;
		}
	}
	
	public static void deleteTodo(int id) throws Exception {
		connect();
		String sql = "DELETE FROM todos WHERE id=?";
		PreparedStatement ps = connection.prepareStatement(sql);
		ps.setInt(1, id);
		ps.executeUpdate();
	}
	
	public static void editTodo(int id, String newTodoText) throws Exception {
		connect();
		String sql = "UPDATE todos SET todo=? WHERE id=?";
		PreparedStatement ps = connection.prepareStatement(sql);
		ps.setString(1, newTodoText);
		ps.setInt(2, id);
		ps.executeUpdate();
	}
	
}
