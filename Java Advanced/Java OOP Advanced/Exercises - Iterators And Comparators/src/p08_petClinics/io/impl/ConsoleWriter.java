package p08_petClinics.io.impl;

import p08_petClinics.io.interfaces.Writer;

public final class ConsoleWriter implements Writer {

    @Override
    public <T> void write(T line) {
        System.out.print(line);
    }

    @Override
    public <T> void writeLine(T line) {
        System.out.println(line);
    }

}
