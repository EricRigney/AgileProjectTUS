
package tus.ie;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import java.util.UUID;

public class LoginAuthenticatorTest {

    @Test
    public void testRegisterAccount() {

        LoginAuthenticator authenticator =
                new LoginAuthenticator();

        String username = "test_" + UUID.randomUUID();

        boolean result =
                authenticator.registerAccount(username, "password123");

        assertTrue(result);
        assertTrue(authenticator.accountExists(username));
    }

    @Test
    public void testDuplicateUsername() {

        LoginAuthenticator authenticator =
                new LoginAuthenticator();

        String username = "test_" + UUID.randomUUID();

        authenticator.registerAccount(username, "password123");

        boolean result =
                authenticator.registerAccount(username, "another123");

        assertFalse(result);
    }

    @Test
    public void testAuthenticateCorrectDetails() {

        LoginAuthenticator authenticator =
                new LoginAuthenticator();

        assertTrue(
                authenticator.authenticate("admin", "admin123")
        );
    }

    @Test
    public void testAuthenticateIncorrectPassword() {

        LoginAuthenticator authenticator =
                new LoginAuthenticator();

        assertFalse(
                authenticator.authenticate("admin", "wrongpassword")
        );
    }

    @Test
    public void testAccountExists() {

        LoginAuthenticator authenticator =
                new LoginAuthenticator();

        assertTrue(authenticator.accountExists("admin"));
        assertFalse(authenticator.accountExists("unknown_user"));
    }

    @Test
    public void testResetPassword() {

        LoginAuthenticator authenticator =
                new LoginAuthenticator();

        String username = "test_" + UUID.randomUUID();

        authenticator.registerAccount(username, "oldpass123");

        boolean result =
                authenticator.resetPassword(username, "newpass123");

        assertTrue(result);

        assertTrue(
                authenticator.authenticate(username, "newpass123")
        );

        assertFalse(
                authenticator.authenticate(username, "oldpass123")
        );
    }

    @Test
    public void testRegisterEmptyUsername() {

        LoginAuthenticator authenticator =
                new LoginAuthenticator();

        assertFalse(
                authenticator.registerAccount("", "password123")
        );
    }
}


    