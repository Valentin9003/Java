package factories;

import interfaces.Appender;
import interfaces.Layout;
import models.appenders.ConsoleAppender;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;

public class AppenderFactoryTest {

    private final String CONSOLE_APPENDER_TYPE = "ConsoleAppender";
    private final String WRRONG_CONSOLE_APPENDER_TYPE = "ConsoleAppenderWrrong";

    @Test
    public void createTest() {
        Layout mock = Mockito.mock(Layout.class);

        Appender appender = AppenderFactory.create(CONSOLE_APPENDER_TYPE, mock);

        Assert.assertTrue(appender != null);
    }

    @Test
    public void createTestWithNullLayout() {
        Layout mock = Mockito.mock(Layout.class);

        Appender appender = AppenderFactory.create(WRRONG_CONSOLE_APPENDER_TYPE, mock);

        Assert.assertTrue(appender == null);
    }
}