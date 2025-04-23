package test;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class StringUtilsTest {
    StringUtils utils = new StringUtils();

    @Test void testReverse() { assertEquals("cba", utils.reverse("abc")); }
    @Test void testIsPalindromeTrue() { assertTrue(utils.isPalindrome("madam")); }
    @Test void testIsPalindromeFalse() { assertFalse(utils.isPalindrome("hello")); }
    @Test void testToUpperCase() { assertEquals("HELLO", utils.toUpperCase("hello")); }
}

