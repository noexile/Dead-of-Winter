package model.user;

public class User {
	
	private String username;
	private String password;
	private String email;
	private int uniqueId;
	
	
	public User(String username, String password, String email, int uniqueId) {
		this.username = username;
		this.password = password;
		this.email = email;
		this.uniqueId = uniqueId;
	}

	
	public String getUsername() {
		return username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public String getEmail() {
		return email;
	}
	
	public int getUniqueId() {
		return uniqueId;
	}
	
}
