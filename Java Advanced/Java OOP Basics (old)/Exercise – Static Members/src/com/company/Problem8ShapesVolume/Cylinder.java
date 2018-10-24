package com.company.Problem8ShapesVolume;

public class Cylinder {
    private double radius;
    private double height;

    public Cylinder(double radius, double height) {
        this.setRadius(radius);
        this.setHeight(height);
    }

    public double getRadius() {
        return radius;
    }

    private void setRadius(double radius) {
        this.radius = radius;
    }

    public double getHeight() {
        return height;
    }

    private void setHeight(double height) {
        this.height = height;
    }
}
