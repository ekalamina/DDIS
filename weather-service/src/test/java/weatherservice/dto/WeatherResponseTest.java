package weatherservice.dto;

import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;
import weatherservice.dto.weatherrequest.*;

public class WeatherResponseTest {
    @Test
    public void testConstructor() {
        WeatherRequest weatherRequest = new WeatherRequest();
        weatherRequest.setLocation(new Location());
        ForecastDay forecastDay = new ForecastDay();
        forecastDay.setDay(new Day());
        Forecast forecast = new Forecast();
        forecast.setForecastDay(new ForecastDay[]{forecastDay});
        weatherRequest.setForecast(forecast);
        WeatherResponse actualWeatherResponse = new WeatherResponse(weatherRequest);
        assertNull(actualWeatherResponse.getTemperature());
        assertNull(actualWeatherResponse.getDate());
        assertNull(actualWeatherResponse.getLocation());
    }
}

