package ru.sbt.currencyService.DAO.Entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;
import ru.sbt.currencyService.DTO.DollarResponse;

public class DollarTest {
    @Test
    public void testConstructor() {
        Dollar actualDollar = new Dollar(new DollarResponse());
        assertNull(actualDollar.getDate());
        assertNull(actualDollar.getValue());
    }

    @Test
    public void testConstructor2() {
        DollarResponse dollarResponse = new DollarResponse();
        dollarResponse.setValue(10.0);
        Dollar actualDollar = new Dollar(dollarResponse);
        assertNull(actualDollar.getDate());
        assertEquals(10.0, actualDollar.getValue().doubleValue());
    }

    @Test
    public void testSetValue() {
        Dollar dollar = new Dollar();
        dollar.setValue(10.0);
        assertEquals(10.0, dollar.getValue().doubleValue());
    }
}

