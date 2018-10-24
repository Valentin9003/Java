package entity.antiHeroDto;

public class Titan extends AntiHero {

    public Titan(String name, int energy, double health, double intelligence, double evilness) {
        super(name, energy, health, intelligence, evilness);
    }

    @Override
    public double attack() {
        /** Returns the attack points of the given character.
         * •	Titan: attack power  = (energy + intelligence + special)  * 3. */
        return (this.getEnergy() + this.getIntelligence() + this.getSpecial()) * 3;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString());
        sb.append(System.lineSeparator())
                .append(String.format("####Titan Attack Power: %.2f", this.attack()));

        return sb.toString();
    }
}
