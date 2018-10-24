import core.Engine;
import io.impl.ConsoleReader;
import io.impl.ConsoleWriter;
import io.interfaces.Reader;
import io.interfaces.Writer;

public class Main {
    public static void main(String[] args) {
        Reader reader = new ConsoleReader();
        Writer writer = new ConsoleWriter();

        Engine engine = new Engine(reader, writer);
        engine.run();
    }
}
