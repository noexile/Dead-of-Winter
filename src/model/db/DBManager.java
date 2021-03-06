package model.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class DBManager {
	
	public enum ColumnNames {USERS,STATS,SURVIVORS, ITEMS,SECRET_OBJECTIVES}

	private final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	
	private final String USER = "kiro";
	private final String PASS = "kiro";
	private final static String DB_NAME = "dead_of_winter_game"; // Date Base name
	

	private final String DB_URL = "jdbc:mysql://localhost:3306/" + DB_NAME;

	private Connection conn = null;
	private Statement stmt = null;
	
	private static DBManager instance = null;
	
	private DBManager() {
		try {
			Class.forName(JDBC_DRIVER);
			System.out.println("Driver loaded successfully");
		} catch (ClassNotFoundException e) {
			System.out.println("No such driver imported");
		}
		
		try {
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			System.out.println("Connection to database was successfully");
			
		} catch (SQLException e) {
			System.out.println("Something went wrong with the connection to the database: "  + e.getMessage());
		}
		
		createSchema(conn);
		addTablesToSchema(conn);
		
	}
	
	public static DBManager getInstance() {
		if(instance == null) {
	         instance = new DBManager();
	      }
	      return instance;
	}
		
	private void addTablesToSchema(Connection conn) {
		
		PreparedStatement statement = null;
		
		String users = "CREATE TABLE IF NOT EXISTS "+ ColumnNames.USERS.toString().toLowerCase() + " (user_id int PRIMARY KEY AUTO_INCREMENT, username VARCHAR(25) UNIQUE NOT NULL, pass VARCHAR(100) NOT NULL, email VARCHAR(25) UNIQUE NOT NULL)";
		String players = "CREATE TABLE IF NOT EXISTS " + ColumnNames.STATS.toString().toLowerCase() + "  (player_id int NOT NULL, game_played int NOT NULL  ,game_won int NOT NULL,zombies_killed int NOT NULL , FOREIGN KEY (player_id) REFERENCES " + DB_NAME + "." + ColumnNames.USERS.toString().toLowerCase() + " (user_id))";
		String survivors = "CREATE TABLE IF NOT EXISTS "+ ColumnNames.SURVIVORS.toString().toLowerCase() +" (name VARCHAR(25) PRIMARY KEY UNIQUE NOT NULL, influence INT NOT NULL, attackValue INT NOT NULL, searchValue INT NOT NULL,currentLocation VARCHAR(25) NOT NULL,link VARCHAR(50) NOT NULL)";
		String items = "CREATE TABLE IF NOT EXISTS " + ColumnNames.ITEMS.toString().toLowerCase() + " (name VARCHAR(25) PRIMARY KEY UNIQUE NOT NULL, type VARCHAR(25) NOT NULL, link VARCHAR(50) NOT NULL, needed INT NOT NULL) ";
		String survivorObjectives = "CREATE TABLE IF NOT EXISTS "+ ColumnNames.SECRET_OBJECTIVES.toString().toLowerCase() +"(name VARCHAR(25) PRIMARY KEY UNIQUE NOT NULL,type VARCHAR(25) NOT NULL, link VARCHAR(50) NOT NULL, needed INT NOT NULL)";
//		String shopping_entries = "CREATE TABLE IF NOT EXISTS " + getDbName() + "." + ColumnNames.SHOPPING_ENTRIES.toString().toLowerCase() +  " (se_id int PRIMARY KEY AUTO_INCREMENT, item_name VARCHAR(100) NOT NULL, item_value DOUBLE PRECISION, list_id int NOT NULL, FOREIGN KEY (list_id) REFERENCES " + DB_NAME + "." + ColumnNames.SHOPPING_LISTS.toString().toLowerCase() + "(sl_id))";
		
		createTable(conn, statement, users);
		createTable(conn, statement, players);
		createTable(conn, statement, survivors);
		createTable(conn, statement, items);
		createTable(conn, statement, survivorObjectives);
//		createTable(conn, statement, shopping_entries);
					
		System.out.println("All tables loaded successfully!");
	}

	private void createTable(Connection conn, PreparedStatement statement, String users) {
		
		try {
			statement = conn.prepareStatement(users);
			statement.executeUpdate(users);
			
		} catch (SQLException e) {
			System.out.println("Creation of tables failed: " + e.getMessage());
		}
	}

	private void createSchema(Connection conn) {
		try {			
			String createSchema = "CREATE SCHEMA IF NOT EXISTS `" + getDbName() + "` DEFAULT CHARACTER SET utf8";
			PreparedStatement statement = conn.prepareStatement(createSchema);
			statement.executeUpdate(createSchema);
			System.out.println("Schema created successfully.");
			
		} catch (SQLException e) {
			System.out.println("Creation of schema failed: " + e.getMessage());
		}	
	}

	public Connection getConnection() {
		return conn;
	}
	
	public void closeConnection() {
		try {
			this.conn.close();
			System.out.println("Connection closed!");
		} catch (SQLException e) {
			System.out.println("Problem while closing the connection: " + e.getMessage());
		}
	}

	public static String getDbName() {
		return DB_NAME;
	}

}
