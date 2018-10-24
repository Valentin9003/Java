package entity.heroDto;

import entity.ComicCharacterImpl;

/** There are 2 types of heros – MarvelHero and DCHero */
public abstract class Hero extends ComicCharacterImpl {

    private double heroism;

    public Hero(String name, int energy, double health, double intelligence, double heroism) {
        super(name, energy, health, intelligence);
        this.setHeroism(heroism);
    }

    public double getHeroism() {
        return this.heroism;
    }

    private void setHeroism(double heroism) {
        if (heroism < 0) {
            throw new IllegalArgumentException("Heroism should be a possitive number!");
        }
        this.heroism = heroism;
    }

    @Override
    public double getSpecial() {
        return this.getHeroism();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString());
        sb.append(System.lineSeparator())
                .append(String.format("###Heroism: %.2f", this.getHeroism()));
        return sb.toString();
    }
}
