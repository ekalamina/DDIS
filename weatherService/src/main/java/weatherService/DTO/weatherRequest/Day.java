package weatherService.DTO.weatherRequest;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Day {

    Double avgtemp_c;

    public Double getAvgtemp_c() {
        return avgtemp_c;
    }

    public void setAvgtemp_c(Double avgtemp_c) {
        this.avgtemp_c = avgtemp_c;
    }


}
