package models;

import interfaces.Attack;
import interfaces.Behavior;
import observers.AbstractObserver;
import observers.Subject;

import java.util.Objects;

public class Blob extends AbstractObserver {

    private final int ZERO_HEALTH = 0;

    private String name;
    private int currentHealth;
    private int damage;
    private Behavior behavior;
    private Attack attack;
    private int initialHealth;

    public Blob(String name, int health, int damage, Behavior behavior, Attack attack, Subject subject) {
        if (behavior == null || attack == null) {
            throw new IllegalStateException();
        }
        this.name = name;
        this.currentHealth = health;
        this.damage = damage;
        this.behavior = behavior;
        this.attack = attack;
        this.initialHealth = health;
        subject.attach(this);
    }

    public int getHealth() {
        return this.currentHealth;
    }

    public void setHealth(int health) {
        this.currentHealth = health;

        if (this.currentHealth < ZERO_HEALTH) {
            this.currentHealth = ZERO_HEALTH;
        }

        if (this.currentHealth <= this.initialHealth / 2
                && !this.behavior.isTriggered()) {
            this.getBehavior().trigger(this);
        }
    }

    public int getDamage() {
        return this.damage;
    }

    public void setDamage(int currentDamage) {
        this.damage = currentDamage;
    }

    public Behavior getBehavior() {
        return this.behavior;
    }

    public String getName() {
        return this.name;
    }

    public void attack(Blob target) {
        if (this.getHealth() > ZERO_HEALTH && target.getHealth() > ZERO_HEALTH) {
            this.attack.execute(this, target);
        }
    }

    public void update() {
        if (this.getBehavior().isTriggered()) {
            this.getBehavior().applyRecurrentEffect(this);
        }
    }

    @Override
    public String toString() {
        if (this.getHealth() <= 0) {
            return String.format("Blob %s KILLED", this.getName());
        }

        return String.format("Blob %s: %s HP, %s Damage", this.getName(), this.getHealth(), this.getDamage());
    }

}
