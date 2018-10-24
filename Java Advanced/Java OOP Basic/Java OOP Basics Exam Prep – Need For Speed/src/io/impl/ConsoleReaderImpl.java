package io.impl;

import io.interfaces.Reader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public final class ConsoleReaderImpl implements Reader {

    private BufferedReader reader;

    public ConsoleReaderImpl() {
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
