package p03_employee_info.core;

import p03_employee_info.contracts.Runnable;
import p03_employee_info.contracts.Formatter;
import p03_employee_info.contracts.InfoProvider;
import p03_employee_info.contracts.Writer;
import p03_employee_info.models.Employee;

import java.util.List;

public class ConsoleClient implements Runnable {

    private Formatter formatter;
    private InfoProvider provider;
    private Writer writer;

    public ConsoleClient(Formatter formatter, InfoProvider provider, Writer writer) {
        this.formatter = formatter;
        this.provider = provider;
        this.writer = writer;
    }

    @Override
    public void run() {
        List<Employee> employeesSortedByName = this.provider.getEmployeesSortedByName();
        Iterable<Employee> employeesSortedBySalary = this.provider.getEmployeesSortedBySalary();

        String firstResult = this.formatter.format(employeesSortedByName);
        String secondResult = this.formatter.format(employeesSortedBySalary);

        this.writer.writeLine("Employees sorted by name:");
        this.writer.writeLine(firstResult);
        this.writer.writeLine("Employees sorted by salary:");
        this.writer.writeLine(secondResult);
    }
}
