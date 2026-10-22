package tus.ie;

public class LoginAuthenticator {
	
	public boolean authenticate(String username, String password) {
		
		if (username.equals("admin") && password.equals("password123")) {
			return true;
		}
		
		if (username.equals("student") && password.equals("java123")) {
			return true;
		}
		
		return false;
	}
	
	
}
