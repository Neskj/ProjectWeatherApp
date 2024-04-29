package neskj.ProjectWeatherApp.POJO;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class CityTest {

    @Test
    public void creationCityHappyFlow() {

        City city = new City();
        city.setCity("Balashikha");

        assertNotNull(city);
        assertEquals("Balashikha", city.getCity());
    }
}
