package neskj.ProjectWeatherApp.Proxy;

import feign.Param;
import feign.RequestLine;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;


public interface MessageProxy {

    @RequestLine("POST /data/2.5/weather?q={city}&appid={key}")
    String proxySend(@Param String city,@Param String key);
}

