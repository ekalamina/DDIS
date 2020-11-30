package weatherService.DAO;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import weatherService.DAO.Entity.Weather;

@Repository
public interface WeatherCrudRepository extends CrudRepository<Weather, Long> {

}
