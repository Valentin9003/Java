package p06_birthdayCelebrations.models.impl;

import p06_birthdayCelebrations.models.contracts.Mammals;

public class BaseMammal implements Mammals {

    private String name;
    private String birthdate;

    public BaseMammal(String name, String birthdate) {
        this.name = name;
        this.birthdate = birthdate;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getBirthdate() {
        return this.birthdate;
    }
}
