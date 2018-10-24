package p05_pizzaCalories.models;

import p05_pizzaCalories.models.util.ConfigModifiers;

import java.util.List;

public class Dough {

    private static final List<String> FLOUR_TYPES = List.of("White", "Wholegrain");
    private static final List<String> BAKING_TECHNIQUES = List.of("Crispy", "Chewy", "Homemade");
    private static final String INVALID_DOUGH_MODIFIERS_EXCEPTION_MESSAGE = "Invalid type of dough.";
    private static final int MIN_DOUGH_WEIGHT = 1;
    private static final int MAX_DOUGH_WEIGHT = 200;
    private static final String INVALID_DOUGH_WEIGHT_EXCEPTION_MESSAGE = "Dough weight should be in the range [1..200].";
    private static final int BASE_CALORIES_PER_GRAM = 2;

    private String type;
    private String bakingTechnique;
    private int weightInGrams;

    public Dough(String type, String bakingTechnique, int weightInGrams) {
        this.setType(type);
        this.setBakingTechnique(bakingTechnique);
        this.setWeightInGrams(weightInGrams);
    }

    public String getType() {
        return this.type;
    }

    private void setType(String type) {
        if (!FLOUR_TYPES.contains(type)) {
            throw new IllegalArgumentException(INVALID_DOUGH_MODIFIERS_EXCEPTION_MESSAGE);
        }
        this.type = type;
    }

    public String getBakingTechnique() {
        return this.bakingTechnique;
    }

    private void setBakingTechnique(String bakingTechnique) {
        if (!BAKING_TECHNIQUES.contains(bakingTechnique)) {
            throw new IllegalArgumentException(INVALID_DOUGH_MODIFIERS_EXCEPTION_MESSAGE);
        }
        this.bakingTechnique = bakingTechnique;
    }

    public int getWeightInGrams() {
        return this.weightInGrams;
    }

    private void setWeightInGrams(int weightInGrams) {
        if (weightInGrams < MIN_DOUGH_WEIGHT || weightInGrams > MAX_DOUGH_WEIGHT) {
            throw new IllegalArgumentException(INVALID_DOUGH_WEIGHT_EXCEPTION_MESSAGE);
        }
        this.weightInGrams = weightInGrams;
    }

    public double getCalories() {
        return this.calculateDoughCalories();
    }

    private double calculateDoughCalories() {
        double firstModifier = ConfigModifiers.DOUGH_MODIFIERS.get(this.getType());
        double secondModifier = ConfigModifiers.DOUGH_MODIFIERS.get(this.getBakingTechnique());

        return (BASE_CALORIES_PER_GRAM * this.getWeightInGrams()) * firstModifier * secondModifier;
    }
}
