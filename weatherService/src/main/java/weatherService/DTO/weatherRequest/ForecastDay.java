package weatherService.DTO.weatherRequest;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import weatherService.DTO.weatherRequest.Day;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ForecastDay {
    String date;
    Day day;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Day getDay() {
        return day;
    }

    public void setDay(Day day) {
        this.day = day;
    }
}
