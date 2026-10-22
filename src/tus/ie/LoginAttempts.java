package tus.ie;

public class LoginAttempts {
	
	private int attempts = 0;
	private final int MAX_ATTEMPTS = 3;
	
	public void recordFailedAttempt() {
		if (attempts < MAX_ATTEMPTS)
		attempts++;
	}
	
	public int getAttemptsRemaining() {
		return MAX_ATTEMPTS - attempts;
	}
	
	public boolean isLockedOut() {
		return attempts >= MAX_ATTEMPTS;
	}
	
}
