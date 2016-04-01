package model.interfaces;

import java.util.Map;
import model.db.DBUserDao;


import model.user.User;

public interface IUserDAO {
	
	enum DataSource {
		DB, JSON, XML, CSV, PLC
	}
	
	static IUserDAO getDAO(DataSource ds) {
		switch (ds) {
		case DB:
			return DBUserDao.getInstance();
		default:
			throw new IllegalArgumentException();
		}
	}
	Map<String, User> getAllUsers();
	boolean registerUser(User user);
	boolean checkIfUserExists(String username);
	boolean checkIfEmailExists(String email);
	void updateUser(User loggedUser);
	
}
