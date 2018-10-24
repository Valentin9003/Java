package p03_employee_info;

import p03_employee_info.contracts.*;
import p03_employee_info.contracts.Runnable;
import p03_employee_info.io.ConsoleWriter;
import p03_employee_info.core.ConsoleClient;
import p03_employee_info.models.formatters.ConsoleFormatter;
import p03_employee_info.repositories.EmployeeInfoProvider;
import p03_employee_info.repositories.simulateDatabase.EmployeeDatabase;

public class Main {

    public static void main(String[] args) {
        Writer writer = new ConsoleWriter();
        Database database = new EmployeeDatabase();
        InfoProvider infoProvider = new EmployeeInfoProvider(database);
        Formatter formatter = new ConsoleFormatter();

        Runnable consoleClient = new ConsoleClient(formatter, infoProvider, writer);
        consoleClient.run();
    }
}
