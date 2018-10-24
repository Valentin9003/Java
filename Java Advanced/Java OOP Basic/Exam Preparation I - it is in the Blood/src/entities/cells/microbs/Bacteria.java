package entities.cells.microbs;

public class Bacteria extends Microbe {

    public Bacteria(String id, int health, int positionRow, int positionCol, int virulence) {
        super(id, health, positionRow, positionCol, virulence);
    }

    @Override
    public int getEnergy() {
        return (super.getHealth() + super.getVirulence()) / 3;
    }

    @Override
    public String toString() {
        return String.format("%s%d%n", super.toString(), this.getEnergy());
    }
}
