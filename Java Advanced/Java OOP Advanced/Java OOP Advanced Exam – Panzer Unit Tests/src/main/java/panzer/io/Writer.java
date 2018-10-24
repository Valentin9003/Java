package panzer.io;

import panzer.contracts.OutputWriter;

public class Writer implements OutputWriter {

    public void println(String output) {
        System.out.println(output);
    }


    public void print(String output) {
        System.out.print(output);
    }
}
