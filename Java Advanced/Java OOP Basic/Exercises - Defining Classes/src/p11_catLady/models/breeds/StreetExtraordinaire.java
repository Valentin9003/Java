package p11_catLady.models.breeds;

import p11_catLady.models.Cat;

public class StreetExtraordinaire extends Cat {

    private double decibelsOfMeows;

    public StreetExtraordinaire(String name, double decibelsOfMeows) {
        super(name);
        this.decibelsOfMeows = decibelsOfMeows;
    }

    public double getDecibelsOfMeows() {
        return decibelsOfMeows;
    }

    public void setDecibelsOfMeows(double decibelsOfMeows) {
        this.decibelsOfMeows = decibelsOfMeows;
    }

    @Override
    public String toString() {
        return String.format("%s %s %.2f",
                StreetExtraordinaire.class.getSimpleName(),
                this.getName(),
                this.getDecibelsOfMeows());
    }
}
