package test;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DivisionTest {
    Division d = new Division();

    @Test void testDivideThrowsException() {
        assertThrows(ArithmeticException.class, () -> d.divide(10, 0));
    }
}
