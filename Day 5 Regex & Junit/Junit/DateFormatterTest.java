package test;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DateFormatterTest {

    @Test
    public void testValidDateFormat() {
        assertEquals("25-12-2022", DateFormatter.formatDate("2022-12-25"));
    }

    @Test
    public void testInvalidDateFormat() {
        assertThrows(IllegalArgumentException.class, () -> DateFormatter.formatDate("25/12/2022"));
    }
}
