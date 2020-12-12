package weatherservice.dto.weatherRequest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

import org.junit.jupiter.api.Test;

public class ForecastDayTest {
    @Test
    public void testSetDate() {
        ForecastDay forecastDay = new ForecastDay();
        forecastDay.setDate("2020-03-01");
        assertEquals("2020-03-01", forecastDay.getDate());
    }

    @Test
    public void testSetDate2() {
        ForecastDay forecastDay = new ForecastDay();
        forecastDay.setDate("2020-03-01");
        assertEquals("2020-03-01", forecastDay.getDate());
    }

    @Test
    public void testSetDay() {
        ForecastDay forecastDay = new ForecastDay();
        Day day = new Day();
        forecastDay.setDay(day);
        assertSame(day, forecastDay.getDay());
    }

    @Test
    public void testSetDay2() {
        ForecastDay forecastDay = new ForecastDay();
        Day day = new Day();
        forecastDay.setDay(day);
        assertSame(day, forecastDay.getDay());
    }
}

