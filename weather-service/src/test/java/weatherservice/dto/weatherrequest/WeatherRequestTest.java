package weatherservice.dto.weatherrequest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;

import org.junit.jupiter.api.Test;

public class WeatherRequestTest {
    @Test
    public void testSetLocation() {
        WeatherRequest weatherRequest = new WeatherRequest();
        weatherRequest.setLocation(new Location());
        assertNull(weatherRequest.getCity());
    }

    @Test
    public void testSetForecast() {
        WeatherRequest weatherRequest = new WeatherRequest();
        Forecast forecast = new Forecast();
        weatherRequest.setForecast(forecast);
        assertSame(forecast, weatherRequest.getForecast());
    }

    @Test
    public void testGetDate() {
        Forecast forecast = new Forecast();
        forecast.setForecastDay(new ForecastDay[]{new ForecastDay()});
        WeatherRequest weatherRequest = new WeatherRequest();
        weatherRequest.setForecast(forecast);
        assertNull(weatherRequest.getDate());
    }

    @Test
    public void testGetTemp() {
        ForecastDay forecastDay = new ForecastDay();
        forecastDay.setDay(new Day());
        Forecast forecast = new Forecast();
        forecast.setForecastDay(new ForecastDay[]{forecastDay});
        WeatherRequest weatherRequest = new WeatherRequest();
        weatherRequest.setForecast(forecast);
        assertNull(weatherRequest.getTemp());
    }

    @Test
    public void testGetCity() {
        WeatherRequest weatherRequest = new WeatherRequest();
        weatherRequest.setLocation(new Location());
        assertNull(weatherRequest.getCity());
    }

    @Test
    public void testToString() {
        WeatherRequest weatherRequest = new WeatherRequest();
        weatherRequest.setLocation(new Location());
        ForecastDay forecastDay = new ForecastDay();
        forecastDay.setDay(new Day());
        Forecast forecast = new Forecast();
        forecast.setForecastDay(new ForecastDay[]{forecastDay});
        weatherRequest.setForecast(forecast);
        assertEquals("WeatherRequestCity null date null temperature null", weatherRequest.toString());
    }
}

