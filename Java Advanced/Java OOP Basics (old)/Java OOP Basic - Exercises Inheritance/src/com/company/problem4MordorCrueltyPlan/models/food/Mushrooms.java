package com.company.problem4MordorCrueltyPlan.models.food;

import com.company.problem4MordorCrueltyPlan.models.Food;

public class Mushrooms extends Food {

    private String name;
    private Integer pointOfHappiness;

    public Mushrooms(String name) {
        this.name = name;
        this.pointOfHappiness = -10;
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
