package p01_system_resources.io;

import p01_system_resources.contracts.Writer;

public class ConsoleWriter implements Writer {

    @Override
    public void writeLine(String line) {
        System.out.println(line);
    }
}
