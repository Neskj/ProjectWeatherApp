package neskj.ProjectWeatherApp.POJO;

public enum Answer {
    TEMP("Температура : "),
    FEELSLIKE("Ощущается как : "),
    TEMPMIN("Минимум : "),
    TEMPMAX("Максимум : ");

    private final String response;

    Answer(String response) {
        this.response = response;
    }

    public String getResponse() {
        return response;
    }


}
