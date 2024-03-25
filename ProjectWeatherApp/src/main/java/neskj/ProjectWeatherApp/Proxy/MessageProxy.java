package neskj.ProjectWeatherApp.Proxy;

import feign.Param;
import feign.RequestLine;

public interface MessageProxy {

    @RequestLine("POST /data/2.5/weather?q={city}&appid={key}")
    String proxySend(@Param String city,@Param String key);
}

