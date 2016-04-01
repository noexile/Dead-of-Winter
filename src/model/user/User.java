package model.user;

public class User {
	
	private String username;
	private String password;
	private String email;
	private int id;
	
	
	public User(String username, String password, String email,int id) {
		this.username = username;
		this.password = password;
		this.email = email;
		this.id = id;
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
	
	public int getId() {
		return id;
	}
	
}
