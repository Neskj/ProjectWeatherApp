package neskj.ProjectWeatherApp.POJO;

public enum Answer {
    TEMP("Temperature : "),
    FEELSLIKE("Feels like : "),
    TEMPMIN("Temperature minimum : "),
    TEMPMAX("Temperature maximum : ");

    private final String response;

    Answer(String response) {
        this.response = response;
    }

    public String getResponse() {
        return response;
    }


}
