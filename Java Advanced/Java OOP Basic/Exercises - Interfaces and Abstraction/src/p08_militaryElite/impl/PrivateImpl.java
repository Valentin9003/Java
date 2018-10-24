package p08_militaryElite.impl;

import p08_militaryElite.contracts.Private;

public class PrivateImpl extends SoldierImpl implements Private {

    private double salary;

    public PrivateImpl(int id, String firstName, String lastName, double salary) {
        super(id, firstName, lastName);
        this.salary = salary;
    }

    @Override
    public double getSalary() {
        return this.salary;
    }

    @Override
    public String toString() {
        StringBuilder privateSoldier = new StringBuilder(super.toString());
        privateSoldier.append(String.format("Salary: %.2f", this.getSalary()));

        return privateSoldier.toString();
    }
}
