package p01_system_resources.models.devices;

import org.junit.Test;
import org.mockito.Mockito;
import p01_system_resources.contracts.Greetable;
import p01_system_resources.contracts.TimeProvider;
import p01_system_resources.contracts.Writer;

import static org.junit.Assert.*;

public class GreetingClockTest {

    private final String MORNING_GREETING = "Good morning...";

    @Test
    public void greeting() {
        Writer writer = Mockito.mock(Writer.class);
        TimeProvider provider = Mockito.mock(TimeProvider.class);
        Mockito.when(provider.getHour()).thenReturn(6);

        Greetable greetableDevice = new GreetingClock(provider, writer);

        greetableDevice.greeting();

        Mockito.verify(writer, Mockito.times(1)).writeLine(MORNING_GREETING);
    }
}