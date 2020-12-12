package ru.sbt.currencyservice.dto;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


@XmlRootElement(name = "Record")
public class DollarRequest {

    @XmlAttribute(name = "Date")
    String date;

    Integer nominal;

    @XmlElement(name = "Value")
    String value;

    public DollarRequest() {
        //pass
    }

    @XmlElement(name = "Nominal")
    public Integer getNominal() {
        return nominal;
    }

    public void setNominal(Integer nominal) {
        this.nominal = nominal;
    }


    public Double getValue() {
        return Double.parseDouble(value.replace(',', '.'));
    }

    public Date getDate() {
        try {
            return new SimpleDateFormat("dd.MM.yyyy").parse(this.date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + "value " + getValue() + " date " + getDate();
    }
}
