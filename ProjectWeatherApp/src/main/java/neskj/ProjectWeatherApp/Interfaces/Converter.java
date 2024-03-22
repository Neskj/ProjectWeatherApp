package neskj.ProjectWeatherApp.Interfaces;

import neskj.ProjectWeatherApp.POJO.Request;

public interface Converter {

    Request convert(String json);
}
