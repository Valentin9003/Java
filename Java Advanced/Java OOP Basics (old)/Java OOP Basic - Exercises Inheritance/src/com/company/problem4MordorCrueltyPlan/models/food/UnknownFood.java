package com.company.problem4MordorCrueltyPlan.models.food;

import com.company.problem4MordorCrueltyPlan.models.Food;

public class UnknownFood extends Food {

    private final Integer HAPPINESS = -1;

    private String name;
    private Integer pointOfHappiness;

    public UnknownFood(String name) {
        this.name = name;
        this.pointOfHappiness = HAPPINESS;
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
