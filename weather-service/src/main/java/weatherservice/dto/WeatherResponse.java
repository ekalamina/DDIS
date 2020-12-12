package weatherservice.dto;

import weatherservice.dto.weatherRequest.WeatherRequest;

public class WeatherResponse {

    private String date;
    private String location;
    private Double temperature;

    public WeatherResponse(WeatherRequest weatherRequest){
        this.date = weatherRequest.getDate();
        this.location = weatherRequest.getCity();
        this.temperature = weatherRequest.getTemp();
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
