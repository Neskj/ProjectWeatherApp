package neskj.ProjectWeatherApp.Controllers;

import neskj.ProjectWeatherApp.Proxy.MessageProxy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RESTcontroller {

    private final MessageProxy messageProxy;

    RESTcontroller(MessageProxy messageProxy) {
        this.messageProxy = messageProxy;
    }

    @GetMapping("/weather/get")
    public String sendToApi() {

        String request = messageProxy.proxySend();
        System.out.println(request);
        return request;
    }
}