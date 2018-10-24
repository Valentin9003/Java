package p06_twitter.io;

import p06_twitter.interfaces.Writer;

public class WriterImpl implements Writer {

    public WriterImpl() {
    }

    @Override
    public void write(String line) {
        System.out.print(line);
    }

    @Override
    public void writeLine(String line) {
        System.out.println(line);
    }
}
