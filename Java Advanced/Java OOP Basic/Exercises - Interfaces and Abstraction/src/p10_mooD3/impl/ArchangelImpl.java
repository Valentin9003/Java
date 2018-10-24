package p10_mooD3.impl;

import p10_mooD3.contracts.Archangel;

public class ArchangelImpl extends BaseCharacterImpl implements Archangel {

    private static final int DEFAULT_HASH_CODE = 21;
    private static final String CHARACTER_TYPE = "Archangel";

    private int mana;

    public ArchangelImpl(String userName, int level, int mana) {
        super(userName, level);
        this.mana = mana;
    }

    @Override
    protected void setHashedPassword() {
        //(username’s characters in reversed order) + (username’s characters' length * 21)
        this.hashedPassword =
                new StringBuilder(this.getUsername()).reverse().toString()
                        + (this.getUsername().length() * DEFAULT_HASH_CODE);
    }

    @Override
    public int getSpecialPoints() {
        return this.mana;
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
