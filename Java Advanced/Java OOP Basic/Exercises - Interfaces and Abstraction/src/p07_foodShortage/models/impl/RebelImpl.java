package p07_foodShortage.models.impl;

import p07_foodShortage.models.contracts.Rebel;

public class RebelImpl implements Rebel {

    private static final int DEFAULT_AMOUNT_FOOD_PEY_BUY = 5;

    private String name;
    private int age;
    private String group;

    public RebelImpl(String name, int age, String group) {
        this.name = name;
        this.age = age;
        this.group = group;
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
    public String getGroup() {
        return this.group;
    }

    @Override
    public void buyFood() {
        Food.TOTAL_FOOD_AMOUNT_PURCHASED += DEFAULT_AMOUNT_FOOD_PEY_BUY;
    }
}
