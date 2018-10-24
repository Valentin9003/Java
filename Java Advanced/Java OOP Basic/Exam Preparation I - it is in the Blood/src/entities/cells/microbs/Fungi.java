package entities.cells.microbs;

public class Fungi extends Microbe {

    public Fungi(String id, int health, int positionRow, int positionCol, int virulence) {
        super(id, health, positionRow, positionCol, virulence);
    }

    @Override
    public int getEnergy() {
        return (super.getHealth() + super.getVirulence()) / 4;
    }

    @Override
    public String toString() {
        return String.format("%s%d%n", super.toString(), this.getEnergy());
    }
}
