package weatherservice.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import weatherservice.dao.entity.Weather;

@Repository
public interface WeatherCrudRepository extends CrudRepository<Weather, Long> {

}
