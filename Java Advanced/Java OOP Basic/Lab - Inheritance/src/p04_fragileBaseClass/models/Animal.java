package p04_fragileBaseClass.models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public abstract class Animal {

    protected List<Food> foodEaten;

    public Animal() {
        this.foodEaten = new ArrayList<>();
    }

    public List<Food> getFoodEaten() {
        return Collections.unmodifiableList(this.foodEaten);
    }

    public void setFoodEaten(List<Food> foodEaten) {
        this.foodEaten = foodEaten;
    }

    public final void eat(Food food) {
        this.foodEaten.add(food);
    }

    public void eatAll(Food[] foods) {
        Arrays.stream(foods).forEach(this::eat);
    }
}
