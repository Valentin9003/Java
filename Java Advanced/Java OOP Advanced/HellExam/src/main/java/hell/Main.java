package hell;

import hell.core.Engine;
import hell.interfaces.InputReader;
import hell.interfaces.OutputWriter;
import hell.io.ConsoleInputReader;
import hell.io.ConsoleOutputWriter;

public class Main {
    public static void main(String[] args) {

        InputReader reader = new ConsoleInputReader();
        OutputWriter writer = new ConsoleOutputWriter();

        Engine engine = new Engine(reader, writer);
        engine.run();
    }
}