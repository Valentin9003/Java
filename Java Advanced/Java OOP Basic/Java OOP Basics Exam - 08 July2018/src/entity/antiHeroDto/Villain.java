package entity.antiHeroDto;

public class Villain extends AntiHero {

    public Villain(String name, int energy, double health, double intelligence, double evilness) {
        super(name, energy, health, intelligence, evilness);
    }

    @Override
    public double attack() {
        /** Returns the attack points of the given character.
         * •	Villain: attack power  = (intelligence * special) / energy.*/
        return (this.getIntelligence() * this.getSpecial()) / this.getEnergy();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString());
        sb.append(System.lineSeparator())
                .append(String.format("####Villain Attack Power: %.2f", this.attack()));

        return sb.toString();
    }
}
