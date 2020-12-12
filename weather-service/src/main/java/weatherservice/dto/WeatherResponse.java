package weatherservice.dto;

import weatherservice.dto.weatherrequest.WeatherRequest;

public class WeatherResponse {

    private String date;
    private String location;
    private Double temperature;

    public WeatherResponse(WeatherRequest weatherRequest){
        setDate(weatherRequest.getDate());
        setLocation(weatherRequest.getCity());
        setTemperature(weatherRequest.getTemp());
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Double getTemperature() {
        return temperature;
    }

    public void setTemperature(Double temperaturer) {
        this.temperature = temperaturer;
    }

    @Override
    public String toString() {
        return "Date " + getDate() + " Location " + getLocation() + " temperature " + getTemperature().toString();
    }
}
