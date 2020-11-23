package weatherService.DTO.weatherRequest;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Forecast {
    public ForecastDay[] forecastday;

    public ForecastDay[] getForecastDay() {
        return forecastday;
    }

    public void setForecastDay(ForecastDay[] forecastday) {
        this.forecastday = forecastday;
    }
}
