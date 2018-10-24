package entity.heroDto;

public class DCHero extends Hero {

    public DCHero(String name, int energy, double health, double intelligence, double heroism) {
        super(name, energy, health, intelligence, heroism);
    }

    @Override
    public double attack() {
        /** Returns the attack points of the given character.
         * •	DCHero: attack power  = energy / 1.5 + special + intelligence. */
        return this.getEnergy() / 1.5 + this.getSpecial() + this.getIntelligence();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString());
        sb.append(System.lineSeparator())
                .append(String.format("####DC Attack Power: %.2f", this.attack()));

        return sb.toString();
    }
}
