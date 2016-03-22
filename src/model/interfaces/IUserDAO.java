package model.interfaces;

import java.util.Map;

import model.user.User;

public interface IUserDAO {
	
	Map<String, User> getAllUsers();
	boolean registerUser(User user);
	boolean checkIfUserExists(String username);
	boolean checkIfEmailExists(String email);
	void updateUser(User loggedUser);
	
}
