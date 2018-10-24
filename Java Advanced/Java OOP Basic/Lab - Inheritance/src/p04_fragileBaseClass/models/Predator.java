package p04_fragileBaseClass.models;

import java.util.Collections;

public class Predator extends Animal {

    private int health;

    public Predator(int health) {
        this.health = health;
    }

    public int getHealth() {
        return this.health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    @Override
    public void eatAll(Food[] foods) {
        Collections.addAll(super.getFoodEaten(), foods);
    }
}
