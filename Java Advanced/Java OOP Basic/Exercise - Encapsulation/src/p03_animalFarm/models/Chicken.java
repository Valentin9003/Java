package p03_animalFarm.models;

import java.text.DecimalFormat;

public class Chicken {

    private static final double EGGS_PER_DAY_YOUNG_CHICKEN = 2.0F;
    private static final double EGGS_PER_DAY_MATURE_CHICKEN = 1.0F;
    private static final double EGGS_PER_DAY_OLD_CHICKEN = 0.75F;

    private String name;
    private int age;

    public Chicken(String name, int age) {
        this.setName(name);
        this.setAge(age);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.isEmpty() || name.trim().length() < 1) {
            throw new IllegalArgumentException("Name cannot be empty.");
        }
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age < 0 || age > 15) {
            throw new IllegalArgumentException("Age should be between 0 and 15.");
        }
        this.age = age;
    }

    public double productPerDay() {
        return calculateProductPerDay();
    }

    private double calculateProductPerDay() {
        return this.getAge() < 6 ? EGGS_PER_DAY_YOUNG_CHICKEN :
                this.getAge() < 12 ? EGGS_PER_DAY_MATURE_CHICKEN :
                        EGGS_PER_DAY_OLD_CHICKEN;
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("0.##");
        return String.format("Chicken %s (age %d) can produce %s eggs per day.",
                this.getName(),
                this.getAge(),
                df.format(this.productPerDay()));
    }
}
