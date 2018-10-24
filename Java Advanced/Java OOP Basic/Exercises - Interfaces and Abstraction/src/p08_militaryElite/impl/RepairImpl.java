package p08_militaryElite.impl;

import p08_militaryElite.contracts.Repair;

public class RepairImpl implements Repair {

    private String partName;
    private int workedHours;

    public RepairImpl(String partName, int workedHours) {
        this.partName = partName;
        this.workedHours = workedHours;
    }

    @Override
    public String getPartName() {
        return this.partName;
    }

    @Override
    public int getWorkedHours() {
        return this.workedHours;
    }

    @Override
    public String toString() {
        return String.format("  Part Name: %s Hours Worked: %d",
                this.getPartName(),
                this.getWorkedHours());
    }
}
