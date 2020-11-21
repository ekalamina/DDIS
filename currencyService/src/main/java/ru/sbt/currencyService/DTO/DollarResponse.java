package ru.sbt.currencyService.DTO;

import java.util.Date;

public class DollarResponse {

    private Date date;
    private Double value;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }
    @Override
    public String toString() {
        return  "Value " + getValue() + " at " + getDate();
    }
}
