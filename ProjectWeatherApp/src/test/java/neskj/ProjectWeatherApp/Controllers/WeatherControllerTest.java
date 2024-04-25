package neskj.ProjectWeatherApp.Controllers;

import neskj.ProjectWeatherApp.Interfaces.Converter;
import neskj.ProjectWeatherApp.Proxy.MessageProxy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
public class WeatherControllerTest {

    @Mock
    private Converter converter;
    @Mock
    private MessageProxy messageProxy;
    @InjectMocks
    private WeatherController weatherController;

    @Test
    public void getWeatherReturnPage(){

        assertNotNull(weatherController.getWhether());
        assertEquals("weather.html",weatherController.getWhether());
    }


//здесь проблема с доступом через feign client, не могу замокать

    @Test
    public void postWeatherHappyFlow(){



    }



}
