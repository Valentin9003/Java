package io.impl;

import io.interfaces.Writer;

public final class ConsoleWriterImpl implements Writer {

    @Override
    public void writeLine(String line) {
        System.out.println(line);
    }

    @Override
    public void write(String line) {
        System.out.print(line);
    }
}
