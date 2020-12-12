package weatherservice.dto.weatherrequesttests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class DayTest {
    @Test
    public void testSetAvgTemp() {
        Day day = new Day();
        day.setAvgTemp(10.0);
        assertEquals(10.0, day.getAvgTemp().doubleValue());
    }
}

