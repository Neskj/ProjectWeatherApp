package neskj.ProjectWeatherApp;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableFeignClients(basePackages = "neskj.ProjectWeatherApp.Proxy")
public class FeignConfig {
}
