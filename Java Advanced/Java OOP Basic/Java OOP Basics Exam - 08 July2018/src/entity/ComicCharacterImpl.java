package entity;

import entity.interfaces.ComicCharacter;
import entity.interfaces.SuperPower;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public abstract class ComicCharacterImpl implements ComicCharacter {

    private String name;
    private int energy;
    private double health;
    private double intelligence;
    private List<SuperPower> powers;

    public ComicCharacterImpl(String name, int energy, double health, double intelligence) {
        this.setName(name);
        this.setEnergy(energy);
        this.setHealth(health);
        this.setIntelligence(intelligence);
        this.powers = new LinkedList<>();
    }

    private void setName(String name) {
        if (!name.matches("^[A-Za-z_]+$")) {
            throw new IllegalArgumentException("Comic Character name is not in the correct format!");
        } else if (name.length() < 2 || name.length() > 12) {
            throw new IllegalArgumentException("Comic Character name is not in the correct format!");
        }
        this.name = name;
    }

    private void setEnergy(int energy) {
        if (energy < 0 || energy > 300) {
            throw new IllegalArgumentException("Energy is not in the correct range!");
        }
        this.energy = energy;
    }

    private void setHealth(double health) {
        if (health < 0) {
            throw new IllegalArgumentException("Health should be a possitive number!");
        }
        this.health = health;
    }

    private void setIntelligence(double intelligence) {
        if (intelligence < 0 || intelligence > 200) {
            throw new IllegalArgumentException("Intelligence is not in the correct range!");
        }
        this.intelligence = intelligence;
    }

    public String getName() {
        return this.name;
    }

    public int getEnergy() {
        return this.energy;
    }

    public double getHealth() {
        return this.health;
    }

    public double getIntelligence() {
        return this.intelligence;
    }

    public List<SuperPower> getPowers() {
        return Collections.unmodifiableList(this.powers);
    }

    @Override
    public void takeDamage(double damage) {
        //The Comic Character health is reduce from the damage
        this.health -= damage;
    }

    @Override
    public void boostCharacter(int energy, double health, double intelligence) {
        //Changes Comic Character energy,health and inteligence
        // with the new values but first you have to see if they are correct.
        this.setEnergy(energy);
        this.setHealth(health);
        this.setIntelligence(intelligence);
    }

    @Override
    public String useSuperPowers() {
        //If the Comic character doesn't have a super power , return "<comic character name> has no super powers!"
        //	If the character has powers , iterate over the colection and for every power:
        //	- add to characters energy the Super power points;
        //	- add to characters health the Super power points multiplied by two;
        //	Else returns "<comic character name> used his super powers!"
        if (this.powers.size() == 0) {
            return String.format("%s has no super powers!", this.getName());
        } else {
            for (SuperPower power : powers) {
                this.energy += power.getPowerPoints();
                this.health += power.getPowerPoints() * 2;
            }
        }

        return String.format("%s used his super powers!", this.getName());
    }

    @Override
    public void addSuperPower(SuperPower superPower) {
        this.powers.add(superPower);
    }

    @Override
    public boolean containsThisSuperpower(String superPower) {
        for (SuperPower power : this.getPowers()) {
            if (power.getName().equals(superPower)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("#Name: %s", this.getName()))
                .append(System.lineSeparator())
                .append(String.format("##Health: %.2f// Energy: %d// Intelligence: %.2f",
                        this.getHealth(),
                        this.getEnergy(),
                        this.getIntelligence()));

        return sb.toString();
    }
}
