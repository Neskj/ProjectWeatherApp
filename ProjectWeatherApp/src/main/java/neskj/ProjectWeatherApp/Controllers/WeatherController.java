package neskj.ProjectWeatherApp.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WeatherController {

    @GetMapping("/weather")
    public String getWhether(){

        return "weather.html";
    }

    @PostMapping("/weather")
    public String postWhether(@RequestParam String city, Model page){

        page.addAttribute("city",city);
        return "weather.html";
    }
}
