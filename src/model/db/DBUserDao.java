package model.db;

import java.io.UnsupportedEncodingException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import model.interfaces.IUserDao;
import model.user.User;

public class DBUserDao implements IUserDao {
	
	private Map<String, User> allUsers = new HashMap<String, User>();
	private DBManager manager;
	private static DBUserDao instance;
	
	private DBUserDao() {
		manager = DBManager.getInstance();
	}
	
	public static DBUserDao getInstance(){
		if(instance == null)
			instance = new DBUserDao();
		return instance;
	}
	
	private boolean addUserInDB(User user) {
		boolean success = true;
		String query = "INSERT INTO " + DBManager.getDbName() + "." + DBManager.ColumnNames.USERS.toString() + " (username, pass, email) VALUES ( ? ,MD5( ? ), ? )";
		
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
	public Map<String,User> getAllUsers() {
		
		if(this.allUsers.size()<1){
			try (Statement st = DBManager.getInstance().getConnection().createStatement()) {
				String query = "SELECT user_id, username, pass, email FROM " + DBManager.getDbName() + "." + DBManager.ColumnNames.USERS.toString() + "";
				ResultSet rs = st.executeQuery(query);
				
				while (rs.next()) {
					int id = rs.getInt("user_id");
					String username = rs.getString("username");
					String pass = rs.getString("pass");
					String email = rs.getString("email");
					
					User user = new User(username, pass, email, id);
					this.allUsers.put(username, user);
				}
			} catch (SQLException e) {
			} 
		}
		
		return this.allUsers;
	}

	@Override
	public boolean registerUser(User user) {
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
		try {
			u.setPassword(convertToMd5(u.getPassword()));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.allUsers.put(u.getUsername(), u);
	}
	
	@Override
	public void updateUser(User loggedUser) {
		String query = "UPDATE USERS SET pass = MD5( ? ), email = ? WHERE username = ?;";
		try(PreparedStatement st = DBManager.getInstance().getConnection().prepareStatement(query);) {
			st.setString(1, loggedUser.getPassword());
			st.setString(2, loggedUser.getEmail());
			st.setString(3, loggedUser.getUsername());
			st.execute();
			if(allUsers.containsKey(loggedUser.getUsername()) && allUsers.containsValue(loggedUser)){
				allUsers.get(loggedUser.getUsername()).setPassword(convertToMd5(loggedUser.getPassword()));
				allUsers.get(loggedUser.getUsername()).setEmail(loggedUser.getEmail());
			}
			} catch (SQLException e) {
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

	@Override
	public boolean usernameValidate(String username) {
		String query = "SELECT COUNT(username) AS count FROM USERS WHERE username = '"+ username +"';";
		try(Statement st = manager.getConnection().createStatement()) {
			ResultSet result = st.executeQuery(query);
			result.next();
			if(result.getInt("count") == 0){
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return false;
	}

	@Override
	public User getUser(String username) {
		String query = "SELECT username,pass,email,user_id FROM USERS WHERE username = '"+ username +"';";
		try(PreparedStatement st = DBManager.getInstance().getConnection().prepareStatement(query);) {
				ResultSet result = st.executeQuery(query);
				result.next();
				int id = result.getInt("user_id");
				String user = result.getString("username");
				String pass = result.getString("pass");
				String email = result.getString("email");
				System.out.println(user + " " + pass + " " + email + " " +id + " " + username);
				return new User(username, pass, email, id);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	private static String convertToMd5(final String md5) throws UnsupportedEncodingException {
        StringBuffer sb=null;
        try {
            final java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5");
            final byte[] array = md.digest(md5.getBytes("UTF-8"));
            sb = new StringBuffer();
            for (int i = 0; i < array.length; ++i) {
                sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1, 3));
            }
            return sb.toString();
        } catch (final java.security.NoSuchAlgorithmException e) {
        }
        return sb.toString();
    }

}
