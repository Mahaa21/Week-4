package test;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UserRegistrationTest {

    @Test
    public void testValidRegistration() {
        assertDoesNotThrow(() -> UserRegistration.registerUser("user1", "user1@example.com", "password123"));
    }

    @Test
    public void testInvalidUsername() {
        assertThrows(IllegalArgumentException.class, () -> UserRegistration.registerUser("", "user@example.com", "password123"));
    }

    @Test
    public void testInvalidEmail() {
        assertThrows(IllegalArgumentException.class, () -> UserRegistration.registerUser("user1", "userexample.com", "password123"));
    }

    @Test
    public void testInvalidPassword() {
        assertThrows(IllegalArgumentException.class, () -> UserRegistration.registerUser("user1", "user@example.com", "pass"));
    }
}
