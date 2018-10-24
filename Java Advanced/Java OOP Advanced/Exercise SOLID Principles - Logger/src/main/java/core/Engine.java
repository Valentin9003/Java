package core;

import factories.AppenderFactory;
import factories.LayoutFactory;
import interfaces.*;
import interfaces.Runnable;
import io.interfaces.Reader;
import io.interfaces.Writer;
import models.enums.ReportLevel;
import models.loggers.MessageLogger;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Engine implements Runnable{

    private final String TERMINATE_PROGRAM = "END";
    private final String DEFAULT_LOGGER_PREFIX = "log";

    private Reader reader;
    private Writer writer;
    private Logger logger;

    public Engine(Reader reader, Writer writer) {
        this.reader = reader;
        this.writer = writer;
    }

    @Override
    public void run() {
        addAppendersToThisLogger();

        String line;
        while (true) {
            line = this.reader.readLine();
            if (TERMINATE_PROGRAM.equalsIgnoreCase(line)) {
                break;
            }

            String[] messageTokens = line.split("\\|");
            logMessage(messageTokens);
        }

        this.logger.getInfo(this.writer);
    }

    private void logMessage(String[] messageTokens) {
        String level = messageTokens[0];
        String dateTime = messageTokens[1];
        String message = messageTokens[2];

        String methodName = DEFAULT_LOGGER_PREFIX
                + String.valueOf(level.charAt(0)) + level.substring(1).toLowerCase();

        try {
            Method method = this.logger.getClass().getDeclaredMethod(methodName, String.class, String.class);
            method.invoke(this.logger, dateTime, message);

        } catch (NoSuchMethodException
                | IllegalAccessException
                | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    private void addAppendersToThisLogger() {
        int numberOfAppender = Integer.parseInt(this.reader.readLine());
        Appender[] appenders = new Appender[numberOfAppender];

        for (int i = 0; i < numberOfAppender; i++) {
            String[] appenderTokens = reader.readLine().split("\\s+");
            String appenderType = appenderTokens[0];
            String layoutType = appenderTokens[1];

            Layout layout = LayoutFactory.create(layoutType);
            Appender appender = AppenderFactory.create(appenderType, layout);

            if (appenderTokens.length > 2) {
                String level = appenderTokens[2];
                appender.setReportLevel(Enum.valueOf(ReportLevel.class, level));
            }

            appenders[i] = appender;
        }

        this.logger = new MessageLogger(appenders);
    }
}
