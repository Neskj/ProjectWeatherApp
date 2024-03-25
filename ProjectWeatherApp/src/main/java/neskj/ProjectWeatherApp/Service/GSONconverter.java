package neskj.ProjectWeatherApp.Service;

import neskj.ProjectWeatherApp.Interfaces.Converter;
import neskj.ProjectWeatherApp.POJO.Request;
import org.apache.tomcat.util.json.JSONParser;
import org.apache.tomcat.util.json.ParseException;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.logging.Logger;

@Service
public class GSONconverter implements Converter {

    private static final Logger logger = Logger.getLogger(GSONconverter.class.getName());
    private LinkedHashMap<String, Object> weatherData;
    private Request request;

    @Override
    public Request convert(String json) {

        logger.info("JSON is come to ---->>> converter " + json);  //take from endpoint
        JSONParser parser = new JSONParser(json);
        try {
            weatherData = (LinkedHashMap<String, Object>) parser.parse();
        } catch (ParseException e) {
            logger.info("!!!!-->>Exception while try to parse JSON<<--!!!!" + e);
        }
        LinkedHashMap<String, Object> listOfParam = (LinkedHashMap<String, Object>) weatherData.get("main");
        BigDecimal k = new BigDecimal("273.15");
        BigDecimal temp = (BigDecimal) listOfParam.get("temp");
        BigDecimal feelsLike = (BigDecimal) listOfParam.get("feels_like");
        BigDecimal tMin = (BigDecimal) listOfParam.get("temp_min");
        BigDecimal tMax = (BigDecimal) listOfParam.get("temp_max");
        request = new Request.Builder()
                .addTemp(temp.subtract(k).toString())
                .addFeelsLike(feelsLike.subtract(k).toString())
                .addTempMin(tMin.subtract(k).toString())
                .addTempMax(tMax.subtract(k).toString())
                .build();
        logger.info("Check parametres:" + "\n" + "Temperature ->>> " + request.getTemp() + "\n" + "Feels like->>> "
                + request.getFeelsLike() + "\n" + "Minimum ->>> " + request.getTempMin() + "\n" + "Maximum ->>> " + request.getTempMax());
        return request;
    }
}
