
package tus.ie;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;

public class LoginAuthenticatorTest {

    @Test
    void testValidAdminLogin() {

        // Arrange
        LoginAuthenticator authenticator = new LoginAuthenticator();

        // Act
        boolean result = authenticator.authenticate("admin", "admin123");

        // Assert
        assertTrue(result);
    }

    @Test
    void testValidStudentLogin() {

        // Arrange
        LoginAuthenticator authenticator = new LoginAuthenticator();

        // Act
        boolean result = authenticator.authenticate("student", "java123");

        // Assert
        assertTrue(result);
    }

    @Test
    void testIncorrectPassword() {

        // Arrange
        LoginAuthenticator authenticator = new LoginAuthenticator();

        // Act
        boolean result = authenticator.authenticate("admin", "wrong123");

        // Assert
        assertFalse(result);
    }

    @Test
    void testIncorrectUsername() {

        // Arrange
        LoginAuthenticator authenticator = new LoginAuthenticator();

        // Act
        boolean result = authenticator.authenticate("unknown", "admin123");

        // Assert
        assertFalse(result);
    }

    @Test
    void testAccountExists() {

        // Arrange
        LoginAuthenticator authenticator = new LoginAuthenticator();

        // Act
        boolean result = authenticator.accountExists("admin");

        // Assert
        assertTrue(result);
    }

    @Test
    void testAccountDoesNotExist() {

        // Arrange
        LoginAuthenticator authenticator = new LoginAuthenticator();

        // Act
        boolean result = authenticator.accountExists("unknown");

        // Assert
        assertFalse(result);
    }

    @Test
    void testResetPassword() {

        // Arrange
        LoginAuthenticator authenticator = new LoginAuthenticator();

        // Act
        boolean result = authenticator.resetPassword("admin", "newpass123");

        // Assert
        assertTrue(result);
        assertTrue(authenticator.authenticate("admin", "newpass123"));
    }

    @Test
    void testResetPasswordInvalidUsername() {

        // Arrange
        LoginAuthenticator authenticator = new LoginAuthenticator();

        // Act
        boolean result = authenticator.resetPassword("unknown", "newpass123");

        // Assert
        assertFalse(result);
    }

    @Test
    void testResetPasswordEmpty() {

        // Arrange
        LoginAuthenticator authenticator = new LoginAuthenticator();

        // Act
        boolean result = authenticator.resetPassword("admin", "");

        // Assert
        assertFalse(result);
    }

    @Test
    void testResetPasswordNull() {

        // Arrange
        LoginAuthenticator authenticator = new LoginAuthenticator();

        // Act
        boolean result = authenticator.resetPassword("admin", null);

        // Assert
        assertFalse(result);
    }
}
