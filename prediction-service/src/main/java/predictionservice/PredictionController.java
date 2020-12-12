package predictionservice;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/predict")
public class PredictionController {

    private final PredictionService predictionService;

    public PredictionController(PredictionService predictionService) {
        this.predictionService = predictionService;
    }

    @GetMapping(value = "/getPredictionForTomorrow", produces = MediaType.APPLICATION_JSON_VALUE)
    public Double getPredictionForTomorrow() {
        return predictionService.getPrediction();
    }

}
