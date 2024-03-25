package neskj.ProjectWeatherApp;

import neskj.ProjectWeatherApp.Proxy.MessageProxy;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableFeignClients(basePackages = "neskj.ProjectWeatherApp.Proxy")
public class FeignConfig {

    @Bean
    MessageProxy messageProxy(){
        return new MessageProxy() {
            @Override
            public String proxySend(String city, String key) {
                return null;
            }
        };
    }
}







