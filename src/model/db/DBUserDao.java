package model.db;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import model.interfaces.IUserDAO;
import model.user.User;

public class DBUserDao implements IUserDAO {
	
	private Map<String, User> allUsers;
	
	private void addUser(User user) {
		
		String query = "INSERT INTO " + DBManager.getDbName() + "." + DBManager.ColumnNames.USERS.toString().toLowerCase() + " (username, pass, email) VALUES ( ? , ? , ? )";
		
		try (PreparedStatement prepStatement = DBManager.getInstance().getConnection().prepareStatement(query)) {	
			prepStatement.setString(1, user.getUsername());
			prepStatement.setString(2, user.getPassword());
			prepStatement.setString(3, user.getEmail());
			prepStatement.execute();
		} catch (SQLException e) {
			// TODO correct forward to error page
		}	
	}

	@Override
	public Map<String, User> getAllUsers() {
		Map<String, User> users = new HashMap<>();
		
		try (Statement st = DBManager.getInstance().getConnection().createStatement()) {
			String query = "SELECT username, pass, email, user_id FROM " + DBManager.getDbName() + "." + DBManager.ColumnNames.USERS.toString().toLowerCase() + "";
			ResultSet rs = st.executeQuery(query);
			
			while (rs.next()) {
				String username = rs.getString("username");
				String pass = rs.getString("pass");
				String email = rs.getString("email");
				int userId = rs.getInt("user_id");
				
				User user = new User(username, pass, email, userId);
				users.put(username, user);
			}
		} catch (SQLException e) {
			// TODO correct forward to error page
		} 
		
		return users;
	}

	@Override
	public User registerUser(User user) {
		addUser(user); // adds user to DB
		User theNewUserWithID = null;
		
		for(Map.Entry<String, User> entry : this.allUsers.entrySet()) {
			if (entry.getValue().getUsername().equals(user.getUsername())) {
				theNewUserWithID = new User(user.getUsername(), user.getPassword(), user.getEmail(), user.getUniqueId());
			}
		}
		
		this.allUsers.put(user.getUsername(), theNewUserWithID); // adds user to cache
		
		return theNewUserWithID;
	}

	@Override
	public boolean checkIfUserExists(String username) {
		if (this.allUsers.containsKey(username)) {
			return true;
		}
		return false;
	}

	@Override
	public boolean checkIfEmailExists(String email) {
		for(Map.Entry<String, User> entry : this.allUsers.entrySet()) {
			if (entry.getValue().getEmail().equals(email)) {
				return true;
			}
		}
		return false;
	}

}
