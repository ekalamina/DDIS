package weatherService.DTO;

import java.util.ArrayList;
import java.util.List;

public class WeatherListResponse {

    private List<WeatherResponse> weatherResponse;

    public WeatherListResponse(){
        this.weatherResponse = new ArrayList<>();
    }

    public List<WeatherResponse> getWeatherRespons() {
        return this.weatherResponse;
    }


}