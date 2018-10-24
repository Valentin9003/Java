package com.company.problem4MordorCrueltyPlan.models.food;

import com.company.problem4MordorCrueltyPlan.models.Food;

public class Lembas extends Food {

    private String name;
    private Integer pointOfHappiness;

    public Lembas(String name) {
        this.name = name;
        this.pointOfHappiness = 3;
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
