
package tus.ie;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LoginAttemptsTest {

    private LoginAttempts loginAttempts;

    @BeforeEach
    void setUp() {
        loginAttempts = new LoginAttempts();
    }

    // Test 1: Initial attempts should be 3
    @Test
    void testInitialAttempts() {
        assertEquals(3, loginAttempts.getAttemptsRemaining());
    }

    // Test 2: First failed attempt
    @Test
    void testFirstFailedAttempt() {
        loginAttempts.recordFailedAttempt();

        assertEquals(2, loginAttempts.getAttemptsRemaining());
        assertFalse(loginAttempts.isLockedOut());
    }

    // Test 3: Second failed attempt
    @Test
    void testSecondFailedAttempt() {
        loginAttempts.recordFailedAttempt();
        loginAttempts.recordFailedAttempt();

        assertEquals(1, loginAttempts.getAttemptsRemaining());
        assertFalse(loginAttempts.isLockedOut());
    }

    // Test 4: Third failed attempt locks account
    @Test
    void testThirdFailedAttemptLocksAccount() {
        loginAttempts.recordFailedAttempt();
        loginAttempts.recordFailedAttempt();
        loginAttempts.recordFailedAttempt();

        assertEquals(0, loginAttempts.getAttemptsRemaining());
        assertTrue(loginAttempts.isLockedOut());
    }

    // Test 5: Account remains locked after extra attempt
    @Test
    void testAdditionalFailedAttempt() {
        loginAttempts.recordFailedAttempt();
        loginAttempts.recordFailedAttempt();
        loginAttempts.recordFailedAttempt();
        loginAttempts.recordFailedAttempt();

        assertEquals(0, loginAttempts.getAttemptsRemaining());
        assertTrue(loginAttempts.isLockedOut());
    }
}
}
