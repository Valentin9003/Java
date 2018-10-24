package com.company.birthdayCelebrations;

public class Pet extends Societies {

    public static final String DEFAULT_ID = null;

    private String name;

    public Pet(String name, String birthday) {
        super(DEFAULT_ID, birthday);
        this.setName(name);
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }
}
