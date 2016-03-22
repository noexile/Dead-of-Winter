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
	
	private Map<String, User> allUsers = new HashMap<String, User>();
	
	private boolean addUserInDB(User user) {
		boolean success = true;
		String query = "INSERT INTO " + DBManager.getDbName() + "." + DBManager.ColumnNames.USERS.toString().toLowerCase() + " (username, pass, email) VALUES ( ? , ? , ? )";
		
		try (PreparedStatement prepStatement = DBManager.getInstance().getConnection().prepareStatement(query)) {	
			prepStatement.setString(1, user.getUsername());
			prepStatement.setString(2, user.getPassword());
			prepStatement.setString(3, user.getEmail());
			prepStatement.execute();
		} catch (SQLException e) {
			success = false;
		}	
		return success;
	}

	@Override
	public Map<String, User> getAllUsers() {
		
		if(this.allUsers.size()<1){
			try (Statement st = DBManager.getInstance().getConnection().createStatement()) {
				String query = "SELECT username, pass, email FROM " + DBManager.getDbName() + "." + DBManager.ColumnNames.USERS.toString().toLowerCase() + "";
				ResultSet rs = st.executeQuery(query);
				
				while (rs.next()) {
					String username = rs.getString("username");
					String pass = rs.getString("pass");
					String email = rs.getString("email");
					
					User user = new User(username, pass, email);
					this.allUsers.put(username, user);
				}
			} catch (SQLException e) {
				// TODO correct forward to error page
			} 
		}
		
		return this.allUsers;
	}

	@Override
	public boolean registerUser(User user) {
		//Transaction!!!
		boolean success = addUserInDB(user);

		if(success){
			addUserInMap(user);
			return true;
		}
		return false;
		
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
	
	private void addUserInMap(User u){
		this.allUsers.put(u.getUsername(), u);
	}
	
	@Override
	public void updateUser(User loggedUser) {
		String query = "UPDATE USERS SET password = ?, email = ? WHERE username = ?;";
		try(PreparedStatement st = DBManager.getInstance().getConnection().prepareStatement(query);) {
			st.setString(1, loggedUser.getPassword());
			st.setString(2, loggedUser.getEmail());
			st.setString(3, loggedUser.getUsername());
			st.execute();
			} catch (SQLException e) {
				System.out.println("failed update");
		}
	}

}
