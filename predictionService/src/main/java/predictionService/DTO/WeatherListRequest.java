package predictionService.DTO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherListRequest extends ArrayList<WeatherRequest> {

    public WeatherListRequest() {
    }

}