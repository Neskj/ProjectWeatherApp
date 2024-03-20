package neskj.ProjectWeatherApp.Controllers;

import neskj.ProjectWeatherApp.Interfaces.Converter;
import neskj.ProjectWeatherApp.Proxy.MessageProxy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RESTcontroller {

    private final MessageProxy messageProxy;
    private final Converter converter;

    RESTcontroller(MessageProxy messageProxy,Converter converter) {

        this.messageProxy = messageProxy;
        this.converter=converter;
    }

    @GetMapping("/weather/get")
    public String sendToApi() {

        String request = messageProxy.proxySend();
        converter.convert(request);
        return request;
    }
}