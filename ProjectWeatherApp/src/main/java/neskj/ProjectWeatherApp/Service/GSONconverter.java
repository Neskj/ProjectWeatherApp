package neskj.ProjectWeatherApp.Service;

import neskj.ProjectWeatherApp.Interfaces.Converter;
import org.apache.tomcat.util.json.JSONParser;
import org.apache.tomcat.util.json.ParseException;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.LinkedHashMap;

@Service
public class GSONconverter implements Converter {

    private LinkedHashMap<String, Object> weatherData;

    @Override
    public Object convert(String json) {

        System.out.println("JSON is come to ---->>> converter " + json);

        JSONParser parser = new JSONParser(json);
        try {
            weatherData = (LinkedHashMap<String, Object>) parser.parse();
        } catch (ParseException e) {
            System.out.println("ex" + e);
        }

        LinkedHashMap<String,Object> listOfParam= (LinkedHashMap<String, Object>) weatherData.get("main");

        BigDecimal k=new BigDecimal("273.15");

        BigDecimal temp=(BigDecimal) listOfParam.get("temp");
        BigDecimal feelsLike=(BigDecimal) listOfParam.get("feels_like");
        BigDecimal tMin=(BigDecimal) listOfParam.get("temp_min");
        BigDecimal tMax=(BigDecimal) listOfParam.get("temp_max");

        BigDecimal cTemp=temp.subtract(k);
        BigDecimal cFeelsLike=feelsLike.subtract(k);
        BigDecimal cMin=tMin.subtract(k);
        BigDecimal cMax=tMax.subtract(k);

        System.out.println();
        System.out.println("___________________________");
        System.out.println("Pogoda v Moscow:");
        System.out.println("___________________________");
        System.out.println("Temperatura ->>> "+cTemp);
        System.out.println("Oshushaetsja kak->>> "+cFeelsLike);
        System.out.println("Minimum ->>> "+cMin);
        System.out.println("Maximum ->>> "+cMax);



        return json;
    }
}
