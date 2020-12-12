package predictionservice.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class DollarRequestTest {
    @Test
    public void testSetValue() {
        DollarRequest dollarRequest = new DollarRequest();
        dollarRequest.setValue(10.0);
        assertEquals(10.0, dollarRequest.getValue().doubleValue());
    }

    @Test
    public void testSetValue2() {
        DollarRequest dollarRequest = new DollarRequest();
        dollarRequest.setValue(10.0);
        assertEquals(10.0, dollarRequest.getValue().doubleValue());
    }

    @Test
    public void testToString() {
        assertEquals("Value null at null", (new DollarRequest()).toString());
        assertEquals("Value null at null", (new DollarRequest()).toString());
    }
}

