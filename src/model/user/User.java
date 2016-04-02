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
	
	public User(String username, String password, String email) {
		this.username = username;
		this.password = password;
		this.email = email;
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


	public void setEmail(String email) {
		this.email = email;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public void setId(int id) {
		this.id = id;
	}



	
}
