package p03_employee_info.models.formatters;

import p03_employee_info.models.Employee;
import p03_employee_info.contracts.Formatter;

public class ConsoleFormatter implements Formatter {

    @Override
    public String format(Iterable<Employee> employees) {
        StringBuilder sb = new StringBuilder();
        for (Employee employee : employees) {
            sb.append(employee).append(System.lineSeparator());
        }

        return sb.toString();
    }
}
