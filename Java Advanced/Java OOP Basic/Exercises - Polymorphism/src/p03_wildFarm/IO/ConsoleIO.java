package p03_wildFarm.IO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public final class ConsoleIO {

    private BufferedReader reader;

    public ConsoleIO() {
        this.reader = new BufferedReader(new InputStreamReader(System.in));
    }

    public String readLine() {
        String line = null;
        try {
            line = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return line;
    }

    public void writeLine(String line) {
        System.out.println(line);
    }

    public void close() {
        try {
            this.reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
