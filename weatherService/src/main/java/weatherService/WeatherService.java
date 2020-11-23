package weatherService;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import weatherService.DAO.WeatherDAO;
import weatherService.DTO.WeatherListResponse;
import weatherService.DTO.WeatherResponse;
import weatherService.DTO.weatherRequest.WeatherRequest;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class WeatherService {

    private WeatherDAO weatherDAO;
    @Value("${weather.token}")
    private String token;

    public WeatherService(WeatherDAO weatherDAO){
        this.weatherDAO = weatherDAO;
    }

    public WeatherListResponse getWeathersForLastNDays(int countDays,String city) throws Exception {
        checkCountDays(countDays);
        WeatherListResponse weatherListResponse = new WeatherListResponse();
        getWeathers(countDays, city, weatherListResponse);
        weatherDAO.saveWeather(weatherListResponse);
        return weatherListResponse;
    }

    //Можно выделить в отдельный класс ParametersChecker,
    //но кроме даты тут нечего проверять, поэтому оставила тут.
    private void checkCountDays(int countDays) throws Exception {
        if (countDays < 0 || countDays > 7) {
            throw new Exception();
        }
    }

    private void getWeathers(int countDays, String city, WeatherListResponse weatherListResponse) {
        for (int i = 0; i < countDays; i++){
            WeatherRequest request = new RestTemplate().getForObject(getWeatherUrl(i,city), WeatherRequest.class);
            weatherListResponse.getWeatherRespons().add(new WeatherResponse(request));
            System.out.println(request.toString());
        }
    }

    private String getWeatherUrl(int countDays, String city) {
        String pattern = "yyyy-MM-dd";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        Long callTime = System.currentTimeMillis();
        String date1 = simpleDateFormat.format(new Date(callTime - countDays * 1000 * 60 * 60 * 24));
        return "http://api.weatherapi.com/v1/history.json?key=" + token + "&q=" + city + "&dt=" + date1;
    }

}
