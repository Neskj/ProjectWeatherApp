package neskj.ProjectWeatherApp.Controllers;

import feign.Feign;
import feign.form.spring.SpringFormEncoder;
import neskj.ProjectWeatherApp.Interfaces.Converter;
import neskj.ProjectWeatherApp.POJO.Answer;
import neskj.ProjectWeatherApp.POJO.Request;
import neskj.ProjectWeatherApp.Proxy.MessageProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WeatherController {

    private final MessageProxy messageProxy;
    private final Converter converter;
    @Value("${app.key}")
    private String key;

    @Autowired
    WeatherController(MessageProxy messageProxy,Converter converter){
        this.messageProxy=messageProxy;
        this.converter=converter;
    }

    @GetMapping("/weather")
    public String getWhether(){

        return "weather.html";
    }

    @PostMapping("/weather")
    public String postWhether(@RequestParam String city, Model page) {

        MessageProxy proxyResourse = Feign.builder().encoder(new SpringFormEncoder())
                .target(MessageProxy.class, "https://api.openweathermap.org");
        String json = proxyResourse.proxySend(city, key);
        Request request = converter.convert(json);
        String temp = Answer.TEMP.getResponse() + request.getTemp();
        String feelsLike = Answer.FEELSLIKE.getResponse() + request.getFeelsLike();
        String tempMin = Answer.TEMPMIN.getResponse() + request.getTempMin();
        String tempMax = Answer.TEMPMAX.getResponse() + request.getTempMax();
        page.addAttribute("city", city);
        page.addAttribute("temp", temp);
        page.addAttribute("feelsLike", feelsLike);
        page.addAttribute("tempMin", tempMin);
        page.addAttribute("tempMax", tempMax);
        return "weather.html";
    }
}
