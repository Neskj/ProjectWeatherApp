package neskj.ProjectWeatherApp.Service;

import neskj.ProjectWeatherApp.Interfaces.Converter;
import neskj.ProjectWeatherApp.POJO.Request;
import org.apache.tomcat.util.json.JSONParser;
import org.apache.tomcat.util.json.ParseException;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.LinkedHashMap;

@Service
public class GSONconverter implements Converter {

    private LinkedHashMap<String, Object> weatherData;
    private Request request;

    @Override
    public Request convert(String json) {
        //take from endpoint
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

        request=new Request.Builder()
                .addTemp(temp.subtract(k).toString())
                .addFeelsLike(feelsLike.subtract(k).toString())
                .addTempMin(tMin.subtract(k).toString())
                .addTempMax(tMax.subtract(k).toString())
                .build();

        //Print parametres in log. Its for removing

        String cTemp=temp.subtract(k).toString();
        String cFeelsLike=feelsLike.subtract(k).toString();
        String cMin=tMin.subtract(k).toString();
        String cMax=tMax.subtract(k).toString();



        System.out.println();
        System.out.println("___________________________");
        System.out.println("Pogoda :");
        System.out.println("___________________________");
        System.out.println("Temperatura ->>> "+cTemp);
        System.out.println("Oshushaetsja kak->>> "+cFeelsLike);
        System.out.println("Minimum ->>> "+cMin);
        System.out.println("Maximum ->>> "+cMax);



        return request;
    }
}
