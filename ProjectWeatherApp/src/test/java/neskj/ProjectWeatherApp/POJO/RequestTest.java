package neskj.ProjectWeatherApp.POJO;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class RequestTest {

    private Request expectRequest;

    @BeforeEach
    public void init() {
        expectRequest = new Request.Builder()
                .addTemp("26.56")
                .addFeelsLike("29.34")
                .addTempMin("19.45")
                .addTempMax("31.45")
                .build();
    }

    @Test
    public void createRequestHappyFlow() {

        assertNotNull(expectRequest);
        assertEquals(" Temperature: 26.56, Feels like: 29.34, Temperature min: 19.45, Temperature max: 31.45",
                expectRequest.toString());
    }

    @Test
    public void requestGettersTest() {

        assertEquals("26.56", expectRequest.getTemp());
        assertEquals("29.34", expectRequest.getFeelsLike());
        assertEquals("19.45", expectRequest.getTempMin());
        assertEquals("31.45", expectRequest.getTempMax());
    }
}
