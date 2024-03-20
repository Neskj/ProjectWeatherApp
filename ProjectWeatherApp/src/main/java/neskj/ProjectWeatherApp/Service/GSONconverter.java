package neskj.ProjectWeatherApp.Service;

import neskj.ProjectWeatherApp.Interfaces.Converter;
import org.springframework.stereotype.Service;

@Service
public class GSONconverter implements Converter {
    
    @Override
    public Object convert(String json) {

        System.out.println("JSON is come to ---->>> converter "+json);


        return json;
    }
}
