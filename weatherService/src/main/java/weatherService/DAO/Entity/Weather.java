package weatherService.DAO.Entity;

import weatherService.DTO.WeatherResponse;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Weather", uniqueConstraints = @UniqueConstraint(columnNames = {"date", "location"}))
public class Weather {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long weatherId;
    private String date;
    private String location;
    private Double temperature;

    public Weather(WeatherResponse weatherResponse) {
        this.date = weatherResponse.getDate();
        this.location = weatherResponse.getLocation();
        this.temperature = weatherResponse.getTemperature();
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Double getTemperature() {
        return temperature;
    }

    public void setTemperature(Double temperature) {
        this.temperature = temperature;
    }
}
