package com.company.problem4MordorCrueltyPlan.factories;

import com.company.problem4MordorCrueltyPlan.models.Mood;
import com.company.problem4MordorCrueltyPlan.models.mood.Angry;
import com.company.problem4MordorCrueltyPlan.models.mood.Happy;
import com.company.problem4MordorCrueltyPlan.models.mood.JavaScript;
import com.company.problem4MordorCrueltyPlan.models.mood.Sad;

public class MoodFactory {

    public static Mood getMood(Integer happinessPoint) {
        if (happinessPoint < -5) {
            return new Angry();
        } else if (happinessPoint >= -5 && happinessPoint < 0) {
            return new Sad();
        } else if (happinessPoint >= 0 && happinessPoint <= 15) {
            return new Happy();
        } else{
            return new JavaScript();
        }


    }
}
