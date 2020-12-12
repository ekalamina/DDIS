package weatherservice.dto.weatherRequest;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Forecast {
    private ForecastDay[] forecastday;

    public ForecastDay[] getForecastDay() {
        return this.forecastday;
    }

    public void setForecastDay(ForecastDay[] forecastday) {
        this.forecastday = forecastday;
    }
}
