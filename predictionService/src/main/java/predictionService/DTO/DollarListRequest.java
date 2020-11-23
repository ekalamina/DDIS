package predictionService.DTO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DollarListRequest extends ArrayList<DollarRequest> {

    public DollarListRequest() {
    }

}