package test;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PasswordValidatorTest {

    @Test
    public void testValidPassword() {
        assertTrue(PasswordValidator.isValid("Password1"));
    }

    @Test
    public void testInvalidPasswordShort() {
        assertFalse(PasswordValidator.isValid("Pass1"));
    }

    @Test
    public void testInvalidPasswordNoUppercase() {
        assertFalse(PasswordValidator.isValid("password1"));
    }

    @Test
    public void testInvalidPasswordNoDigit() {
        assertFalse(PasswordValidator.isValid("Password"));
    }
}
