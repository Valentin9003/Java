package p03_mankind.models;

public class Worker extends Human {

    private static final String INVALID_LAST_NAME_LENGTH_EX_MSG = "Expected length more than 3 symbols!Argument: lastName";
    private static final String INVALID_WEEK_SALARY_EX_MSG = "Expected value mismatch!Argument: weekSalary";
    private static final double WEEK_SALARY_MIN_VALUE = 10.0F;
    private static final String INVALID_WORKING_HOURS_EX_MSG = "Expected value mismatch!Argument: workHoursPerDay";
    private static final double MIN_WORKING_HOURS = 1.0F;
    private static final double MAX_WORKING_HOURS = 12.0F;
    private static final int WEEK_DAYS_AMOUNT = 7;

    private double salary;
    private double workHoursPerDay;

    public Worker(String firstName, String lastName, double salary, double workHoursPerDay) {
        super(firstName, lastName);
        this.setSalary(salary);
        this.setWorkHoursPerDay(workHoursPerDay);
    }

    public double getSalary() {
        return this.salary;
    }

    private void setSalary(double salary) {
        if (salary <= WEEK_SALARY_MIN_VALUE) {
            throw new IllegalArgumentException(INVALID_WEEK_SALARY_EX_MSG);
        }
        this.salary = salary;
    }

    public double getWorkHoursPerDay() {
        return this.workHoursPerDay;
    }

    private void setWorkHoursPerDay(double workHoursPerDay) {
        if (workHoursPerDay < MIN_WORKING_HOURS || workHoursPerDay > MAX_WORKING_HOURS) {
            throw new IllegalArgumentException(INVALID_WORKING_HOURS_EX_MSG);
        }
        this.workHoursPerDay = workHoursPerDay;
    }

    @Override
    protected void setLastName(String lastName) {
        if (lastName.length() <= 3) {
            throw new IllegalArgumentException(INVALID_LAST_NAME_LENGTH_EX_MSG);
        }
        super.setLastName(lastName);
    }

    private double getSalaryPerHour() {
        return (this.getSalary() / WEEK_DAYS_AMOUNT) / this.getWorkHoursPerDay();
    }

    @Override
    public String toString() {
        StringBuilder studentStrBuilder = new StringBuilder();
        studentStrBuilder.append(String.format("First Name: %s", this.getFirstName()))
                .append(System.lineSeparator())
                .append(String.format("Last Name: %s", this.getLastName()))
                .append(System.lineSeparator())
                .append(String.format("Week Salary: %.2f", this.getSalary()))
                .append(System.lineSeparator())
                .append(String.format("Hours per day: %.2f", this.getWorkHoursPerDay()))
                .append(System.lineSeparator())
                .append(String.format("Salary per hour: %.2f", this.getSalaryPerHour()));

        return studentStrBuilder.toString();
    }

}
