package ru.sbt.currencyService.DTO;

import java.util.ArrayList;
import java.util.List;

public class DollarListResponse {

    private List<DollarResponse> dollarResponses;

    public DollarListResponse(){
        this.dollarResponses = new ArrayList<>();
    }

    public List<DollarResponse> getDollarResponses() {
        return this.dollarResponses;
    }

    public void setDollarResponse(List<DollarRequest> dollarRequests) {
        for (DollarRequest dollarRequest : dollarRequests){
            DollarResponse dollarResponse = new DollarResponse();
            dollarResponse.setDate(dollarRequest.getDate());
            dollarResponse.setValue(dollarRequest.getValue());
            this.dollarResponses.add(dollarResponse);
        }
    }

}