package neskj.ProjectWeatherApp.POJO;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AnswerTest {

    @Test
    public void answerGettersTest() {

        assertEquals("Temperature : ", Answer.TEMP.getResponse());
        assertEquals("Feels like : ", Answer.FEELSLIKE.getResponse());
        assertEquals("Temperature minimum : ", Answer.TEMPMIN.getResponse());
        assertEquals("Temperature maximum : ", Answer.TEMPMAX.getResponse());
    }
}
