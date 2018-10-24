package p10_mooD3.impl;

import p10_mooD3.contracts.Demon;

public class DemonImpl extends BaseCharacterImpl implements Demon {

    private static final int DEFAULT_HASH_CODE = 217;
    private static final String CHARACTER_TYPE = "Demon";

    private double energy;

    public DemonImpl(String userName, int level, double energy) {
        super(userName, level);
        this.energy = energy;
    }

    @Override
    protected void setHashedPassword() {
        this.hashedPassword = this.getUsername().length() * DEFAULT_HASH_CODE + "";
    }

    @Override
    public double getSpecialPoints() {
        return this.energy;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(
                String.format("\"%s\" | \"%s\" -> %s",
                        this.getUsername(),
                        this.getHashedPassword(),
                        CHARACTER_TYPE))
                .append(System.lineSeparator())
                .append(this.getSpecialPoints() * this.getLevel());

        return sb.toString();
    }
}
