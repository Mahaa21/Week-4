package test;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.jupiter.api.Assertions.*;

class NumberUtilsTest {
    NumberUtils utils = new NumberUtils();

    @ParameterizedTest
    @ValueSource(ints = {2, 4, 6})
    void testIsEvenTrue(int num) {
        assertTrue(utils.isEven(num));
    }

    @ParameterizedTest
    @ValueSource(ints = {7, 9})
    void testIsEvenFalse(int num) {
        assertFalse(utils.isEven(num));
    }
}
