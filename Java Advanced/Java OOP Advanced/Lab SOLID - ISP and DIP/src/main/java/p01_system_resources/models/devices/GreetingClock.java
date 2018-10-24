package p01_system_resources.models.devices;

import p01_system_resources.contracts.Greetable;
import p01_system_resources.contracts.TimeProvider;
import p01_system_resources.contracts.Writer;

public class GreetingClock implements Greetable {

    private final String MORNING_GREETING = "Good morning...";
    private final String AFTERNOON_GREETING = "Good afternoon...";
    private final String EVENING_GREETING = "Good evening...";

    private TimeProvider timeProvider;
    private Writer writer;

    public GreetingClock(TimeProvider timeProvider, Writer writer) {
        this.timeProvider = timeProvider;
        this.writer = writer;
    }

    @Override
    public void greeting() {
        if (timeProvider.getHour() < 12) {
            this.writer.writeLine(MORNING_GREETING);
        } else if (timeProvider.getHour() < 18) {
            this.writer.writeLine(AFTERNOON_GREETING);
        } else {
            this.writer.writeLine(EVENING_GREETING);
        }
    }
}
