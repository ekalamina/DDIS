package weatherService.DAO;

import org.springframework.stereotype.Component;
import weatherService.DAO.Entity.Weather;
import weatherService.DTO.WeatherListResponse;

import javax.annotation.Resource;

@Component
public class WeatherDAO {

    @Resource
    public WeatherCrudRepository weatherCrudRepository;

    public void saveWeather(WeatherListResponse weatherListResponse) {
        weatherListResponse.getWeatherRespons().forEach(weatherResponse -> {
            try {
                weatherCrudRepository.save(new Weather(weatherResponse));
            } catch (Exception e) {
                System.out.println("Line already exist in database");
            }
        });
    }

}
