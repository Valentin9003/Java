package p03_employee_info.io;

import p03_employee_info.contracts.Writer;

public class ConsoleWriter implements Writer {

    @Override
    public void writeLine(String line) {
        System.out.println(line);
    }
}
