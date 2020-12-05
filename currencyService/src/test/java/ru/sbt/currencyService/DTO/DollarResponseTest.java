package ru.sbt.currencyService.DTO;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class DollarResponseTest {
    @Test
    public void testSetValue() {
        DollarResponse dollarResponse = new DollarResponse();
        dollarResponse.setValue(10.0);
        assertEquals(10.0, dollarResponse.getValue().doubleValue());
    }

    @Test
    public void testToString() {
        assertEquals("Value null at null", (new DollarResponse()).toString());
    }
}

