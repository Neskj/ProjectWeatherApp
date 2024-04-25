package neskj.ProjectWeatherApp.Controllers;

import neskj.ProjectWeatherApp.Interfaces.Converter;
import neskj.ProjectWeatherApp.POJO.Answer;
import neskj.ProjectWeatherApp.POJO.Request;
import neskj.ProjectWeatherApp.Proxy.MessageProxy;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ui.Model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class WeatherControllerTest {

    @Mock
    private Model page;
    @Mock
    private Converter converter;
    @Mock
    private MessageProxy proxy;
    @InjectMocks
    private WeatherController weatherController;

    @Test
    public void getWeatherReturnPage(){

        assertNotNull(weatherController.getWhether());
        assertEquals("weather.html",weatherController.getWhether());
    }


//здесь проблема с доступом через feign client, не могу замокать
/*
    @Test
    public void postWeatherHappyFlow() {

        String cityRequest = "Balashikha";
        String keyApi = "0e7345a38a23c62a0ec49aed8b1d049d";

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

        when(proxy.proxySend(cityRequest, keyApi)).thenReturn(json);
        when(converter.convert(json)).thenReturn(executeRequest);
        assertEquals("weather.html", weatherController.postWhether(cityRequest, page));
        verify(page).addAttribute(Answer.TEMP.getResponse() + executeRequest.getTemp());
        verify(page).addAttribute(Answer.FEELSLIKE.getResponse() + executeRequest.getFeelsLike());
        verify(page).addAttribute(Answer.TEMPMIN.getResponse() + executeRequest.getTempMin());
        verify(page).addAttribute(Answer.TEMPMAX.getResponse() + executeRequest.getTempMax());
    }
    
 */
}
