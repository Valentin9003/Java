package com.company.problem4MordorCrueltyPlan.models.food;

import com.company.problem4MordorCrueltyPlan.models.Food;

public class Melon extends Food {

    private String name;
    private Integer pointOfHappiness;

    public Melon(String name) {
        this.name = name;
        this.pointOfHappiness = 1;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Integer getPointOfHappiness() {
        return this.pointOfHappiness;
    }
}
