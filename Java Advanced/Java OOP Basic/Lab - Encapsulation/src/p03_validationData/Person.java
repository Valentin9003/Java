package p03_validationData;

import java.text.DecimalFormat;

public class Person {

    private String firstName;
    private String lastName;
    private int age;
    private double salary;

    public Person(String firstName, String lastName, int age, double salary) {
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setAge(age);
        this.setSalary(salary);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        if (firstName.length() >= 3) {
            this.firstName = firstName;
        } else {
            throw new IllegalArgumentException("First name cannot be less than 3 symbols");
        }
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if (lastName.length() >= 3) {
            this.lastName = lastName;
        } else {
            throw new IllegalArgumentException("Last name cannot be less than 3 symbols");
        }
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age >= 0) {
            this.age = age;
        } else {
            throw new IllegalArgumentException("Age cannot be zero or negative integer");
        }
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        if (salary >= 460) {
            this.salary = salary;
        } else {
            throw new IllegalArgumentException("Salary cannot be less than 460 leva");
        }
    }

    public void increaseSalary(double bonus) {
//        this.salary = this.age >= 30 ? (this.salary * bonus / 100) : (this.salary * (bonus / 2) / 100);
        double personalBonus = this.age >= 30 ? bonus : bonus / 2;
        this.salary += this.salary * personalBonus / 100;
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("0.0#################");
        return String.format("%s %s gets %s leva", this.getFirstName(), this.getLastName(), df.format(this.getSalary()));
    }
}
