package predictionservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import predictionservice.dto.DollarRequest;
import predictionservice.dto.WeatherRequest;

import java.util.ArrayList;

@Service
public class PredictionService {

    @Value("${weather.url}")
    private String weatherUrl;

    @Value("${currency.url}")
    private String currencyUrl;

    @Autowired
    private RestTemplate restTemplate;

    public Double getPrediction() {
        Double weatherSumm = 0.;
        for (WeatherRequest weatherRequest : getWeather()) {
            weatherSumm += weatherRequest.getTemperature();
        }
        weatherSumm /= getWeather().get(0).getTemperature();
        return getDollars().get(getDollars().size() - 1).getValue() + weatherSumm;
    }

    private ArrayList<DollarRequest> getDollars() {
        String dollarListUrl = currencyUrl + "/currency/getCurrencysForLastNDays/7/";
        return restTemplate.getForObject(dollarListUrl, ArrayList.class);
    }

    private ArrayList<WeatherRequest> getWeather() {
        String weatherListUrl = weatherUrl + "/weather/getWeathersForLastNDays/7/";
        return restTemplate.getForObject(weatherListUrl, ArrayList.class);
    }

}
