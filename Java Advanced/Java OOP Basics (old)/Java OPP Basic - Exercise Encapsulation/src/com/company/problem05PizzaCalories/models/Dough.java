package com.company.problem05PizzaCalories.models;

public class Dough {
    private static final double WHITE_MODIFIER = 1.5;
    private static final double WHOLEGRAIN_MODIFIER = 1.0;
    private static final double CRISPY_MODIFIER = 0.9;
    private static final double CHEWY_MODIFIER = 1.1;
    private static final double HOMEMADE_MODIFIER = 1.0;

    private String flourType;
    private String bakingTechnique;
    private Integer weight;

    public Dough(String flourType, String bakingTechnique, Integer weight) {
        this.setFlourType(flourType);
        this.setBakingTechnique(bakingTechnique);
        this.setWeight(weight);
    }

    private void setFlourType(String flourType) {
        if (!flourType.equalsIgnoreCase("white")
                && !flourType.equalsIgnoreCase("wholegrain")) {
            throw new IllegalArgumentException("Invalid type of dough.");
        }
        this.flourType = flourType;
    }

    private void setBakingTechnique(String bakingTechnique) {
        if (!bakingTechnique.equalsIgnoreCase("crispy")
                && !bakingTechnique.equalsIgnoreCase("chewy")
                && !bakingTechnique.equalsIgnoreCase("homemade")) {
            throw new IllegalArgumentException("Invalid type of dough.");
        }
        this.bakingTechnique = bakingTechnique;
    }

    private void setWeight(Integer weight) {
        if (weight < 1 || weight > 200) {
            throw new IllegalArgumentException("Dough weight should be in the range [1..200].");
        }
        this.weight = weight;
    }

    public double getCalories() {
        return 2 * this.weight * this.getModifier(this.flourType) * this.getModifier(this.bakingTechnique);
    }

    private double getModifier(String type) {
    //Switch by the types - white or wholegrain, crispy, chewy or homemade
        switch (type.toLowerCase()) {
            case "white":
                return Dough.WHITE_MODIFIER;

            case "wholegrain":
                return Dough.WHOLEGRAIN_MODIFIER;

            case "crispy":
                return Dough.CRISPY_MODIFIER;

            case "chewy":
                return Dough.CHEWY_MODIFIER;

            case "homemade":
                return Dough.HOMEMADE_MODIFIER;

            default:
                    return 1.0;
        }
    }
}
