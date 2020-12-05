package predictionService.DTO;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class WeatherRequestTest {
    @Test
    public void testSetDate() {
        WeatherRequest weatherRequest = new WeatherRequest();
        weatherRequest.setDate("2020-03-01");
        assertEquals("2020-03-01", weatherRequest.getDate());
    }

    @Test
    public void testSetDate2() {
        WeatherRequest weatherRequest = new WeatherRequest();
        weatherRequest.setDate("2020-03-01");
        assertEquals("2020-03-01", weatherRequest.getDate());
    }

    @Test
    public void testSetLocation() {
        WeatherRequest weatherRequest = new WeatherRequest();
        weatherRequest.setLocation("Location");
        assertEquals("Location", weatherRequest.getLocation());
    }

    @Test
    public void testSetLocation2() {
        WeatherRequest weatherRequest = new WeatherRequest();
        weatherRequest.setLocation("Location");
        assertEquals("Location", weatherRequest.getLocation());
    }

    @Test
    public void testSetTemperature() {
        WeatherRequest weatherRequest = new WeatherRequest();
        weatherRequest.setTemperature(10.0);
        assertEquals(10.0, weatherRequest.getTemperature().doubleValue());
    }

    @Test
    public void testSetTemperature2() {
        WeatherRequest weatherRequest = new WeatherRequest();
        weatherRequest.setTemperature(10.0);
        assertEquals(10.0, weatherRequest.getTemperature().doubleValue());
    }

    @Test
    public void testToString() {
        WeatherRequest weatherRequest = new WeatherRequest();
        weatherRequest.setTemperature(10.0);
        assertEquals("Date null Location null temperature 10.0", weatherRequest.toString());
    }

    @Test
    public void testToString2() {
        WeatherRequest weatherRequest = new WeatherRequest();
        weatherRequest.setTemperature(10.0);
        assertEquals("Date null Location null temperature 10.0", weatherRequest.toString());
    }
}

