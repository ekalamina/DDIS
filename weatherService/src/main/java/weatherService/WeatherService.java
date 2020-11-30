package weatherService;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import weatherService.DAO.Entity.Weather;
import weatherService.DAO.WeatherCrudRepository;
import weatherService.DTO.WeatherResponse;
import weatherService.DTO.weatherRequest.WeatherRequest;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

@Service
public class WeatherService {

    private WeatherCrudRepository weatherCrudRepository;

    @Value("${weather.token:someToken}")
    private String token;

    private static final String WEATHER_HISTORY = "http://api.weatherapi.com/v1/history.json?key=%s&q=%s&dt=$s";

    public ArrayList<WeatherResponse> getWeathersForLastNDays(int countDays, String city) throws Exception {
        ArrayList<WeatherResponse> weatherListResponse = new ArrayList<>();
        getWeathers(countDays, city, weatherListResponse);
        saveWeather(weatherListResponse);
        return weatherListResponse;
    }

    private void getWeathers(int countDays, String city, ArrayList<WeatherResponse> weatherListResponse) {
        for (int i = 0; i < countDays; i++) {
            WeatherRequest request = new RestTemplate().getForObject(getWeatherUrl(i, city), WeatherRequest.class);
            weatherListResponse.add(new WeatherResponse(request));
            System.out.println(request.toString());
        }
    }

    private String getWeatherUrl(int countDays, String city) {
        String pattern = "yyyy-MM-dd";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        Long callTime = System.currentTimeMillis();
        String date1 = simpleDateFormat.format(new Date(callTime - countDays * 1000 * 60 * 60 * 24));
        return String.format(WEATHER_HISTORY, token, city, date1)
    }

    public void saveWeather(ArrayList<WeatherResponse> weatherListResponse) {
        weatherListResponse.forEach(weatherResponse -> {
            try {
                weatherCrudRepository.save(new Weather(weatherResponse));
            } catch (Exception e) {
                System.out.println("Line already exist in database");
            }
        });
    }
}
