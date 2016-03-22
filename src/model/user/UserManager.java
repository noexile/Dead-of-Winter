package model.user;

import java.util.HashMap;
import java.util.Map;

import model.db.DBUserDao;

public class UserManager {
	
	Map<String, User> users;
	
	public UserManager() {
		this.users = new HashMap<String, User>();
		if (this.users.size() < 1) {
			DBUserDao daoDb = new DBUserDao();
			this.users = daoDb.getAllUsers();
		}
	}
	
	public boolean checkIfUserExists(String username) {
		if (this.users.containsKey(username)) {
			return true;
		}
		return false;
	}
}
