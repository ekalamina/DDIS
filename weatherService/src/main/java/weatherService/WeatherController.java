package weatherService;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import weatherService.DTO.WeatherResponse;

import java.util.List;

@RestController
@RequestMapping("/weather")
public class WeatherController {

    private final WeatherService weatherService;

    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping(value = "/getWeathersForLastNDays/{countDays}/{city}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<WeatherResponse> getWeathersForLastNDays(@PathVariable int countDays,@PathVariable String city) throws Exception {
        return weatherService.getWeathersForLastNDays(countDays,city).getWeatherRespons();
    }
    @GetMapping(value = "/getWeathersForLastNDays/{countDays}/", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<WeatherResponse> getWeathersForLastNDays(@PathVariable int countDays) throws Exception {
        return weatherService.getWeathersForLastNDays(countDays,"Moscow").getWeatherRespons();
    }

}
