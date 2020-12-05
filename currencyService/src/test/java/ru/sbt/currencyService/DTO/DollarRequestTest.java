package ru.sbt.currencyService.DTO;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class DollarRequestTest {
    @Test
    public void testSetNominal() {
        DollarRequest dollarRequest = new DollarRequest();
        dollarRequest.setNominal(1);
        assertEquals(1, dollarRequest.getNominal().intValue());
    }

    @Test
    public void testSetNominal2() {
        DollarRequest dollarRequest = new DollarRequest();
        dollarRequest.setNominal(1);
        assertEquals(1, dollarRequest.getNominal().intValue());
    }


    @Test
    public void testSetValue() {
        DollarRequest dollarRequest = new DollarRequest();
        dollarRequest.setValue("value");
        assertEquals("value", dollarRequest.value);
    }

    @Test
    public void testSetValue2() {
        DollarRequest dollarRequest = new DollarRequest();
        dollarRequest.setValue("value");
        assertEquals("value", dollarRequest.value);
    }

}

