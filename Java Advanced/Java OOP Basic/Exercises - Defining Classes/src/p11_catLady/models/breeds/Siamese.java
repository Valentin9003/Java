package p11_catLady.models.breeds;

import p11_catLady.models.Cat;

public class Siamese extends Cat {

    private double earSize;

    public Siamese(String name, double earSize) {
        super(name);
        this.earSize = earSize;
    }

    public double getEarSize() {
        return earSize;
    }

    public void setEarSize(double earSize) {
        this.earSize = earSize;
    }

    @Override
    public String toString() {
        return String.format("%s %s %.2f",
                Siamese.class.getSimpleName(),
                this.getName(),
                this.getEarSize());
    }
}
