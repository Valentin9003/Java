package com.company.problem4MordorCrueltyPlan.models;

import com.company.problem4MordorCrueltyPlan.factories.FoodFactory;
import com.company.problem4MordorCrueltyPlan.factories.MoodFactory;

import java.util.ArrayList;

public class Gandalf {

    private final Integer DEFAULT_HAPPINESS_POINT = 0;

    private Integer happinessPoint;
    private ArrayList<Food> foods;
    private Mood mood;

    public Gandalf() {
        this.happinessPoint = DEFAULT_HAPPINESS_POINT;
        this.foods = new ArrayList<>();
        this.setMood();
    }

    public Integer getHappinessPoin() {
        return happinessPoint;
    }

    private void setHappinessPoint() {
        for (Food food : foods) {
            this.happinessPoint += food.getPointOfHappiness();
        }
    }

    public void setMood() {
        mood = MoodFactory.getMood(this.happinessPoint);
    }

    public void setFoods(String... foods) {
        for (String food : foods) {
            this.foods.add(FoodFactory.getFood(food));
        }
        if (foods.length >= 1) {
            setHappinessPoint();
        }


    }

    @Override
    public String toString() {
        return String.format("%d%n%s", this.happinessPoint, this.mood);
    }
}
