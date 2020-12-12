package weatherservice;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import weatherservice.dto.WeatherResponse;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.List;

@RestController
@RequestMapping("/weather")
public class WeatherController {

    private final WeatherService weatherService;

    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping(value = {"/getWeathersForLastNDays/{countDays}/{city}","/getWeathersForLastNDays/{countDays}" } , produces = MediaType.APPLICATION_JSON_VALUE)
    public List<WeatherResponse> getWeathersForLastNDays(@PathVariable @Min(0) @Max(7) int countDays,
                                                         @PathVariable(required = false) String city) throws Exception {
        if (city == null) {
            return weatherService.getWeathersForLastNDays(countDays, "Moscow");
        } else {
            return weatherService.getWeathersForLastNDays(countDays, city);
        }
    }
}
