package neskj.ProjectWeatherApp.Proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name="Feign", url="https://api.openweathermap.org")
public interface MessageProxy {

    @PostMapping("/data/2.5/weather?q=${app.city}&appid=${app.key}")
    String proxySend();
}

