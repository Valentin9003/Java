package p01_system_resources;

import p01_system_resources.contracts.Greetable;
import p01_system_resources.contracts.TimeProvider;
import p01_system_resources.contracts.Writer;
import p01_system_resources.models.devices.GreetingClock;
import p01_system_resources.io.ConsoleWriter;
import p01_system_resources.models.providers.TimeProviderImpl;

public class Main {
    public static void main(String[] args) {

        Writer consoleWriter = new ConsoleWriter();
        TimeProvider timeProvider = new TimeProviderImpl();

        Greetable device = new GreetingClock(timeProvider, consoleWriter);
        device.greeting();
    }
}
