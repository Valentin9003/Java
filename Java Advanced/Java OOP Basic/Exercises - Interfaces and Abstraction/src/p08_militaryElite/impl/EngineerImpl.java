package p08_militaryElite.impl;

import p08_militaryElite.contracts.Engineer;
import p08_militaryElite.contracts.Repair;

import java.util.Collections;
import java.util.List;

public class EngineerImpl extends SpecialisedSoldierImpl implements Engineer {

    private List<Repair> repairsSet;

    public EngineerImpl(int id,
                        String firstName,
                        String lastName,
                        double salary,
                        String corps,
                        List<Repair> repairs) {
        super(id, firstName, lastName, salary, corps);
        this.repairsSet = repairs;
    }

    @Override
    public List<Repair> getRepairs() {
        return Collections.unmodifiableList(this.repairsSet);
    }

    @Override
    public String toString() {
        StringBuilder engineer = new StringBuilder(super.toString());
        engineer
                .append(System.lineSeparator())
                .append("Repairs:");

        for (Repair repair : repairsSet) {
            engineer
                    .append(System.lineSeparator())
                    .append(repair.toString());
        }

        return engineer.toString();
    }
}
