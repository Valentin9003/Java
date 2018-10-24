package p08_petClinics.io.impl;

import p08_petClinics.io.interfaces.Reader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public final class ConsoleReader implements Reader {

    private BufferedReader reader;

    public ConsoleReader() {
        this.reader = new BufferedReader(new InputStreamReader(System.in));
    }

    @Override
    public String readLine() {
        String line = null;
        try {
            line = this.reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return line;
    }
}
