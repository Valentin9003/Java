package p08_militaryElite.impl;

import p08_militaryElite.contracts.SpecialisedSoldier;

public abstract class SpecialisedSoldierImpl extends PrivateImpl implements SpecialisedSoldier {

    private static final String CORPS_AIRFORCES = "Airforces";
    private static final String CORPS_MARINES = "Marines";

    private String corps;

    public SpecialisedSoldierImpl(int id,
                                  String firstName,
                                  String lastName,
                                  double salary,
                                  String corps) {
        super(id, firstName, lastName, salary);
        this.setCorps(corps);
    }

    private void setCorps(String corps) {
        if (!CORPS_AIRFORCES.equals(corps) && !CORPS_MARINES.equals(corps)) {
            throw new IllegalArgumentException("Invalid corps!");
        }
        this.corps = corps;
    }

    @Override
    public String getCorps() {
        return this.corps;
    }

    @Override
    public String toString() {
        StringBuilder specialisedSoldier = new StringBuilder(super.toString());
        specialisedSoldier
                .append(System.lineSeparator())
                .append(String.format("Corps: %s", this.getCorps()));

        return specialisedSoldier.toString();
    }
}
