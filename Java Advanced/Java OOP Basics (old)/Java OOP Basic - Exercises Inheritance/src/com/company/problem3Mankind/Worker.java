package com.company.problem3Mankind;

public class Worker extends Human {
    private double weekSalary;
    private double workHoursPerDay;

    public Worker(String firstName, String lastName, double weekSalary, double workHoursPerDay) {
        super(firstName, lastName);
        this.setWeekSalary(weekSalary);
        this.setWorkHoursPerDay(workHoursPerDay);
    }

    private void setWeekSalary(double weekSalary) {
        if (weekSalary < 10) {
            throw new IllegalArgumentException("Expected value mismatch!Argument: weekSalary");
        }
        this.weekSalary = weekSalary;

    }

    private void setWorkHoursPerDay(double workHoursPerDay) {
        if (workHoursPerDay < 1 || workHoursPerDay > 12) {
            throw new IllegalArgumentException("Expected value mismatch!Argument: workHoursPerDay");
        }
        this.workHoursPerDay = workHoursPerDay;
    }

    private double calculateMoneyPerHour() {
        return weekSalary / (7 * workHoursPerDay);
    }

    @Override
    public String toString() {
        return String.format("First Name: %s %n" +
                "Last Name: %s %n" +
                "Week Salary: %.2f %n" +
                "Hours per day: %.2f %n" +
                "Salary per hour: %.2f %n",
                this.getFirstName(),
                this.getLastName(),
                this.weekSalary,
                this.workHoursPerDay,
                this.calculateMoneyPerHour());
    }
}
