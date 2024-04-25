package neskj.ProjectWeatherApp.Service;

import neskj.ProjectWeatherApp.POJO.Request;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
public class GSONconverterTest {

    @InjectMocks
    GSONconverter gsoNconverter;

    @Test
    public void convertHappyFlow() {

        String json = "{\"coord\":{\"lon\":37.9581,\"lat\":55.8094},\"weather\":[{\"id\":804," +
                "\"main\":\"Clouds\",\"description\":\"overcast clouds\",\"icon\":\"04d\"}]," +
                "\"base\":\"stations\",\"main\":{\"temp\":286.17,\"feels_like\":284.47," +
                "\"temp_min\":285.37,\"temp_max\":287.26,\"pressure\":1021,\"humidity\":36}," +
                "\"visibility\":10000,\"wind\":{\"speed\":0.89,\"deg\":193,\"gust\":1.34}," +
                "\"clouds\":{\"all\":85},\"dt\":1713960009,\"sys\":{\"type\":2,\"id\":2088636," +
                "\"country\":\"RU\",\"sunrise\":1713924020,\"sunset\":1713977511},\"timezone\":10800," +
                "\"id\":579464,\"name\":\"Balashikha\",\"cod\":200}";

        Request executeRequest = new Request.Builder()
                .addTemp("13.02")
                .addFeelsLike("11.32")
                .addTempMin("12.22")
                .addTempMax("14.11")
                .build();

        assertNotNull(gsoNconverter.convert(json));
        assertEquals(executeRequest, gsoNconverter.convert(json));
    }
}
