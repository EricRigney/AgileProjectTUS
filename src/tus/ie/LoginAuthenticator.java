package tus.ie;

import java.util.HashMap;
import java.util.Map;
import java.io.*;

public class LoginAuthenticator {

	private Map<String, String> accounts = new HashMap<>();
	
	private final String FILE_NAME = "accounts.txt";

	public LoginAuthenticator() {
		accounts.put("admin", "admin123");
		accounts.put("student", "java123");
	}
	
	// Checks for the right username and password
	public boolean authenticate(String username, String password) {
		String correctPassword = accounts.get(username);

		return correctPassword != null && correctPassword.equals(password);
	}
	
	// Check whether an account exists
	public boolean accountExists(String username) {
		return accounts.containsKey(username);
	}
	
	// Change the password for an existing account
	
	public boolean resetPassword(String username, String newPassword) {
		if(!accountExists(username) || newPassword == null || newPassword.isEmpty()) {
			return false;
		}
		
		accounts.put(username, newPassword);
		return true;
	}
	
	
	/*
	 * public boolean authenticate(String username, String password) {
	 * 
	 * if (username.equals("admin") && password.equals("password123")) { return
	 * true; }
	 * 
	 * if (username.equals("student") && password.equals("java123")) { return true;
	 * }
	 * 
	 * return false; }
	 */

}
