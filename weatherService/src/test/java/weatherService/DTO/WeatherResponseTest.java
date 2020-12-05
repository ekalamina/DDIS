package weatherService.DTO;

import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;
import weatherService.DTO.weatherRequest.Day;
import weatherService.DTO.weatherRequest.Forecast;
import weatherService.DTO.weatherRequest.ForecastDay;
import weatherService.DTO.weatherRequest.Location;
import weatherService.DTO.weatherRequest.WeatherRequest;

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

