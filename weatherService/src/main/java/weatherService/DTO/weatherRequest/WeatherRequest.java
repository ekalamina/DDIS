package weatherService.DTO.weatherRequest;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import weatherService.DTO.weatherRequest.Forecast;
import weatherService.DTO.weatherRequest.Location;


@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherRequest {

    Location location;

    Forecast forecast;


    public WeatherRequest() {
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Forecast getForecast() {
        return forecast;
    }

    public void setForecast(Forecast forecast) {
        this.forecast = forecast;
    }
    public String getDate(){
        return this.forecast.getForecastDay()[0].getDate();
    }
    public Double getTemp(){
        return this.forecast.getForecastDay()[0].getDay().getAvgtemp_c();
    }
    public String getCity(){
        return this.location.getName();
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + "City " + getCity() + " date " + getDate() + " temperature " + getTemp();
    }
}
