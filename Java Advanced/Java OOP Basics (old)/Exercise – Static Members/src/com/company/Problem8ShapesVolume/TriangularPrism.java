package com.company.Problem8ShapesVolume;

public class TriangularPrism {
    private double baseSide;
    private double heightFromBaseSide ;
    private double length;

    public TriangularPrism(double baseSide, double heightFromBaseSide, double length) {
        this.setBaseSide(baseSide);
        this.setHeightFromBaseSide(heightFromBaseSide);
        this.setLength(length);
    }

    public double getBaseSide() {
        return baseSide;
    }

    private void setBaseSide(double baseSide) {
        this.baseSide = baseSide;
    }

    public double getHeightFromBaseSide() {
        return heightFromBaseSide;
    }

    private void setHeightFromBaseSide(double heightFromBaseSide) {
        this.heightFromBaseSide = heightFromBaseSide;
    }

    public double getLength() {
        return length;
    }

    private void setLength(double length) {
        this.length = length;
    }
}
