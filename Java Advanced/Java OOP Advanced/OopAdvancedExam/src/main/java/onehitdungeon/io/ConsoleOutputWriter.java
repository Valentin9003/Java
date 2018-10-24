package onehitdungeon.io;

import onehitdungeon.interfaces.OutputWriter;

public class ConsoleOutputWriter implements OutputWriter {

    @Override
    public void print(String output) {
        System.out.print(output);
    }

    @Override
    public void println(String output) {
        System.out.println(output);
    }
}
