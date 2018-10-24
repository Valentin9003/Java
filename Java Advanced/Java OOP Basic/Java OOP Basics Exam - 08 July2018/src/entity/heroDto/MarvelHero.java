package entity.heroDto;

public class MarvelHero extends Hero {

    public MarvelHero(String name, int energy, double health, double intelligence, double heroism) {
        super(name, energy, health, intelligence, heroism);
    }

    @Override
    public double attack() {
        /** Returns the attack points of the given character.
         * •	MarvelHero: attack power = ((energy + special) * intelligence) / 2.5 */
        return ((this.getEnergy() + this.getSpecial()) * this.getIntelligence()) / 2.5;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString());
        sb.append(System.lineSeparator())
                .append(String.format("####Marvel Attack Power: %.2f", this.attack()));

        return sb.toString();
    }
}
