package p07_foodShortage.models.impl;

import p07_foodShortage.models.contracts.Citizen;

public class CitizenImpl implements Citizen {

    private static final int DEFAULT_AMOUNT_FOOD_PER_BUY = 10;

    private String name;
    private int age;
    private String id;
    private String birthdate;

    public CitizenImpl(String name, int age, String id, String birthdate) {
        this.name = name;
        this.age = age;
        this.id = id;
        this.birthdate = birthdate;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Integer getAge() {
        return this.age;
    }

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public String getBirthdate() {
        return this.birthdate;
    }

    @Override
    public void buyFood() {
        Food.TOTAL_FOOD_AMOUNT_PURCHASED += DEFAULT_AMOUNT_FOOD_PER_BUY;
    }
}
