package p10_mooD3.impl;

import p10_mooD3.contracts.Character;

public abstract class BaseCharacterImpl implements Character {

    private String userName;
    protected String hashedPassword;
    private int level;

    protected BaseCharacterImpl(String userName, int level) {
        this.userName = userName;
        this.level = level;
        this.setHashedPassword();
    }

    protected abstract void setHashedPassword();

    @Override
    public String getUsername() {
        return this.userName;
    }

    @Override
    public String getHashedPassword() {
        return this.hashedPassword;
    }

    @Override
    public int getLevel() {
        return this.level;
    }
}
