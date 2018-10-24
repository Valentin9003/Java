package com.company.mankind;

public class Worker extends Human {

    private double weekSalary;
    private double workHoursPerDay;

    public Worker(String firstName, String lastName, double weekSalary, double workHoursPerDay) {
        super(firstName, lastName);
        this.setWeekSalary(weekSalary);
        this.setWorkHoursPerDay(workHoursPerDay);
    }

    private void setWeekSalary(double weekSalary) {
        if (weekSalary <= 10) {
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
        return (this.weekSalary / 7) / this.workHoursPerDay;
    }

    @Override
    protected void setLastName(String lastName) {
        if (lastName.length() <= 3) {
            throw new IllegalArgumentException("Expected length more than 3 symbols!Argument: lastName");
        }
        super.setLastName(lastName);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("First Name: %s%n", this.getFirstName()))
                .append(String.format("Last Name: %s%n", this.getLastName()))
                .append(String.format("Week Salary: %.2f%n", this.weekSalary))
                .append(String.format("Hours per day: %.2f%n", this.workHoursPerDay))
                .append(String.format("Salary per hour: %.2f%n", this.calculateMoneyPerHour()));
        return sb.toString();
    }
}
