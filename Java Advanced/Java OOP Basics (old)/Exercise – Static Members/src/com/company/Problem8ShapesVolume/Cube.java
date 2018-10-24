package com.company.Problem8ShapesVolume;

public class Cube {
    private double sideLength;

    public Cube(double sideLength) {
        this.setSideLength(sideLength);
    }

    public double getSideLength() {
        return sideLength;
    }

    private void setSideLength(double sideLength) {
        this.sideLength = sideLength;
    }
}
