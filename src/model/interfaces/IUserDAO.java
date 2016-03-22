package model.interfaces;

import java.util.Map;

import model.user.User;

public interface IUserDAO {
	
	Map<String, User> getAllUsers();
	User registerUser(User user);
	boolean checkIfUserExists(String username);
	boolean checkIfEmailExists(String email);
	
}
