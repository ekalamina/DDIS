package predictionService;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import predictionService.DTO.DollarListRequest;
import predictionService.DTO.WeatherListRequest;
import predictionService.DTO.WeatherRequest;

@Service
public class PredictionService {

    @Value("${weather.url}")
    private String weatherUrl;

    @Value("${currency.url}")
    private String currencyUrl;

    public Double getPrediction() throws Exception {
        Double weatherSumm = 0.;
        for (WeatherRequest weatherRequest: getWeather()){
            weatherSumm+=weatherRequest.getTemperature();
        }
        weatherSumm /= getWeather().get(0).getTemperature();
        return getDollars().get(getDollars().size()-1).getValue() + weatherSumm;
    }
    private DollarListRequest getDollars(){
        String dollarListUrl = currencyUrl + "/currency/getCurrencysForLastNDays/7/";
        DollarListRequest request = new RestTemplate().getForObject(dollarListUrl, DollarListRequest.class);
       return request;
    }
    private WeatherListRequest getWeather(){
        String weatherListUrl = weatherUrl + "/weather/getWeathersForLastNDays/7/";
        WeatherListRequest request = new RestTemplate().getForObject(weatherListUrl, WeatherListRequest.class);
        return request;
    }

}
