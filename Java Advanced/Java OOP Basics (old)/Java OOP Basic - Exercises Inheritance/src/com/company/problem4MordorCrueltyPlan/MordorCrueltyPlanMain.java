package com.company.problem4MordorCrueltyPlan;

import com.company.problem4MordorCrueltyPlan.models.Gandalf;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MordorCrueltyPlanMain {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] food = reader.readLine().split("\\s+");
        Gandalf gandalf = new Gandalf();
        gandalf.setFoods(food);
        gandalf.setMood();
        System.out.println(gandalf);
    }
}
