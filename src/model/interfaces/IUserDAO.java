package model.interfaces;

import java.util.Map;
import model.db.DBUserDao;


import model.user.User;

public interface IUserDao {
	
	enum DataSource{DB}
	
	static IUserDao getDAO(DataSource ds) {
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
	boolean usernameValidate(String username);
	User getUser(String username);
	
}
