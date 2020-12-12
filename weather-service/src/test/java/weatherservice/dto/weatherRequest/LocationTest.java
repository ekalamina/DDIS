package weatherservice.dto.weatherRequest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class LocationTest {
    @Test
    public void testSetName() {
        Location location = new Location();
        location.setName("Name");
        assertEquals("Name", location.getName());
    }
}

