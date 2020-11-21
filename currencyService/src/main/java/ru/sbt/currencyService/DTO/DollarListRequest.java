package ru.sbt.currencyService.DTO;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;
@XmlRootElement(name = "ValCurs")
public class DollarListRequest {

    private List<DollarRequest> dollarRequests;

    public DollarListRequest(){}

    @XmlElement(name = "Record")
    public List<DollarRequest> getDollarRequests() {
        return this.dollarRequests;
    }

    public void setDollarRequests(List<DollarRequest> dollarRequests) {
        this.dollarRequests = dollarRequests;
    }
}
