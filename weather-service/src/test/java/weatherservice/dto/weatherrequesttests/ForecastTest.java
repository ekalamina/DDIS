package weatherservice.dto.weatherrequesttests;

import static org.junit.jupiter.api.Assertions.assertSame;

import org.junit.jupiter.api.Test;

public class ForecastTest {
    @Test
    public void testSetForecastDay() {
        ForecastDay forecastDay = new ForecastDay();
        ForecastDay forecastDay1 = new ForecastDay();
        ForecastDay[] forecastDayArray = new ForecastDay[]{forecastDay, forecastDay1, new ForecastDay()};
        Forecast forecast = new Forecast();
        forecast.setForecastDay(forecastDayArray);
        assertSame(forecastDayArray, forecast.getForecastDay());
    }
}

