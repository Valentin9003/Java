package Core;

import contracts.CommandHandler;
import contracts.Reader;
import contracts.Runnable;
import contracts.Writer;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BoatRacingSimulatorEngine implements Runnable {

    private final String END_PROGRAM = "End";

    private CommandHandler commandHandler;
    private Writer writer;
    private Reader reader;

    public BoatRacingSimulatorEngine(CommandHandler commandHandler, Writer writer, Reader reader) {
        this.commandHandler = commandHandler;
        this.writer = writer;
        this.reader = reader;
    }

    @Override
    public void run() {
        while (true) {
            String line = reader.readLine();

            if (END_PROGRAM.equals(line)) {
                break;
            }

            List<String> tokens = Arrays.asList(line.split("\\\\"));

            String name = tokens.get(0);
            List<String> parameters = tokens.stream().skip(1).collect(Collectors.toList());

            try {
                String result = this.commandHandler.executeCommand(name, parameters);
                this.writer.writeLine(result);
            } catch (Exception ex) {
                this.writer.writeLine(ex.getMessage());
            }
        }
    }
}
