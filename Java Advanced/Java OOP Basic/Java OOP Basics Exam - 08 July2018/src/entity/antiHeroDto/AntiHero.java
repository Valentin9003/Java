package entity.antiHeroDto;

import entity.ComicCharacterImpl;

/** There are 2 types of anti heroes – Villain and Titan */
public abstract class AntiHero extends ComicCharacterImpl {

    private double evilness;

    public AntiHero(String name, int energy, double health, double intelligence, double evilness) {
        super(name, energy, health, intelligence);
        this.setEvilness(evilness);
    }

    public double getEvilness() {
        return this.evilness;
    }

    private void setEvilness(double evilness) {
        if (evilness < 0) {
            throw new IllegalArgumentException("Evilness should be a possitive number!");
        }
        this.evilness = evilness;
    }

    @Override
    public double getSpecial() {
        return this.getEvilness();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString());
        sb.append(System.lineSeparator())
                .append(String.format("###Evilness: %.2f", this.getEvilness()));

        return sb.toString();
    }
}
