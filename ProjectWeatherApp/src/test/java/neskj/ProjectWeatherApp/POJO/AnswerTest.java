package neskj.ProjectWeatherApp.POJO;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AnswerTest {

    @Test
    public void answerGettersTest() {

        assertEquals("Температура : ", Answer.TEMP.getResponse());
        assertEquals("Ощущается как : ", Answer.FEELSLIKE.getResponse());
        assertEquals("Минимум : ", Answer.TEMPMIN.getResponse());
        assertEquals("Максимум : ", Answer.TEMPMAX.getResponse());
    }
}
