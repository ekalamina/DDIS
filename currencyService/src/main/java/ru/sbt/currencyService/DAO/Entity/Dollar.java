package ru.sbt.currencyService.DAO.Entity;

import ru.sbt.currencyService.DTO.DollarResponse;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Dollar",uniqueConstraints= @UniqueConstraint(columnNames={"date", "value"}))
public class Dollar {
    Dollar(){

    }
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long dollarId;
    private Date date;
    private Double value;
    public Dollar(DollarResponse dollarResponse){
        this.date = dollarResponse.getDate();
        this.value = dollarResponse.getValue();
    }

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
}
