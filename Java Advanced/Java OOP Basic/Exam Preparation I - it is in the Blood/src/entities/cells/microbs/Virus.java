package entities.cells.microbs;

public class Virus extends Microbe {

    public Virus(String id, int health, int positionRow, int positionCol, int virulence) {
        super(id, health, positionRow, positionCol, virulence);
    }

    @Override
    public int getEnergy() {
        return super.getHealth() + super.getVirulence();
    }

    @Override
    public String toString() {
        return String.format("%s%d%n", super.toString(), this.getEnergy());
    }
}
