package tus.ie;

import java.util.HashMap;
import java.util.Map;

public class LoginAuthenticator {

	private Map<String, String> accounts = new HashMap<>();

	public LoginAuthenticator() {
		accounts.put("admin", "admin123");
		accounts.put("student", "java123");
	}
	
	// Checks for the right username and password
	public boolean authenticate(String username, String password) {
		String correctPassword = accounts.get(username);

		return correctPassword != null && correctPassword.equals(password);
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
