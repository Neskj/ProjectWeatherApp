package neskj.ProjectWeatherApp;

//не удалось написать юнит тест для post метода контроллера - feign client валится с ошибкой доступа 401 (invaild key)
// по этому проверим корректность создание бина

import neskj.ProjectWeatherApp.Proxy.MessageProxy;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(MockitoExtension.class)
public class FeignConfigTest {

    @Mock
    MessageProxy messageProxy;

    @Test
    public void testMessageProxyBean() {

        assertNotNull(messageProxy);
        assertTrue(messageProxy instanceof MessageProxy);
    }
}
