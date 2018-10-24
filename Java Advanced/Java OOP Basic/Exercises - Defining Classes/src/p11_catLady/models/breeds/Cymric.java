package p11_catLady.models.breeds;

import p11_catLady.models.Cat;

public class Cymric extends Cat {

    private double furLength;

    public Cymric(String name, double furLength) {
        super(name);
        this.furLength = furLength;
    }

    public double getFurLength() {
        return furLength;
    }

    public void setFurLength(double furLength) {
        this.furLength = furLength;
    }

    @Override
    public String toString() {
        return String.format("%s %s %.2f",
                Cymric.class.getSimpleName(),
                this.getName(),
                this.getFurLength());
    }
}
