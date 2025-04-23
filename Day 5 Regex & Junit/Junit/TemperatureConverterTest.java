package test;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TemperatureConverterTest {

    @Test
    public void testCelsiusToFahrenheit() {
        assertEquals(98.6, TemperatureConverter.celsiusToFahrenheit(37), 0.1);
    }

    @Test
    public void testFahrenheitToCelsius() {
        assertEquals(0, TemperatureConverter.fahrenheitToCelsius(32), 0.1);
    }
}
