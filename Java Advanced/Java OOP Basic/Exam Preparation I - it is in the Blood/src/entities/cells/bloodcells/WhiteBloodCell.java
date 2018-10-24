package entities.cells.bloodcells;

public class WhiteBloodCell extends BloodCell {

    private int size;

    public WhiteBloodCell(String id, int health, int positionRow, int positionCol, int size) {
        super(id, health, positionRow, positionCol);
        this.setSize(size);
    }

    public int getSize() {
        return this.size;
    }

    private void setSize(int size) {
        this.size = size;
    }

    @Override
    public int getEnergy() {
        //-	WhiteBloodCell: energy = (health + size) * 2.
        return (super.getHealth() + this.getSize()) * 2;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString());
        sb.append(System.lineSeparator())
                .append(String.format("--------Health: %d | Size: %d | Energy: %d",
                        super.getHealth(),
                        this.getSize(),
                        this.getEnergy()))
                .append(System.lineSeparator());

        return sb.toString();
    }
}
