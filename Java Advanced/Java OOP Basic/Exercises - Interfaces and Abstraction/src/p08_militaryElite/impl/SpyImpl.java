package p08_militaryElite.impl;

import p08_militaryElite.contracts.Spy;

public class SpyImpl extends SoldierImpl implements Spy {

    private String codeName;

    public SpyImpl(int id, String firstName, String lastName, String codeName) {
        super(id, firstName, lastName);
        this.codeName = codeName;
    }

    @Override
    public String getCodeName() {
        return this.codeName;
    }

    @Override
    public String toString() {
        StringBuilder spy = new StringBuilder(super.toString());
        spy
                .append(System.lineSeparator())
                .append(String.format("Code Number: %s", this.getCodeName()));

        return spy.toString();
    }
}
