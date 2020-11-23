package predictionService;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import predictionService.DTO.WeatherRequest;

import java.util.List;

@RestController
@RequestMapping("/predict")
public class PredictionController {

    private final PredictionService predictionService;

    public PredictionController(PredictionService predictionService) {
        this.predictionService = predictionService;
    }

    @GetMapping(value = "/getPredictionForTomorrow", produces = MediaType.APPLICATION_JSON_VALUE)
    public Double getPredictionForTomorrow() throws Exception {
        return predictionService.getPrediction();
    }

}
