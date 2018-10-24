package com.company.problem01ClassBox;

public class Box {
    private double length;
    private double width;
    private double height;

    public Box(double length, double width, double height) {
        this.setLength(length);
        this.setWidth(width);
        this.setHeight(height);
    }

    private void setLength(double length) {
        if (length <= 0) {
            throw new IllegalArgumentException("Length cannot be zero or negative.");
        }
        this.length = length;
    }

    private void setWidth(double width) {
        if (width <= 0) {
            throw new IllegalArgumentException("Width cannot be zero or negative.");
        }
        this.width = width;
    }

    private void setHeight(double height) {
        if (height <= 0) {
            throw new IllegalArgumentException("Height cannot be zero or negative.");
        }
        this.height = height;
    }

    public void getSurfaceArea() {
        double surfaceArea =
                2 * this.length * this.width
                + 2 * this.length * this.height
                + 2 * this.width * this.height;

        System.out.println(String.format("Surface Area – %.2f", surfaceArea));
    }

    public void getLateralSurfaceArea() {
        double lateralSurfaceArea = 2 * this.length * this.height + 2 * this.width * this.height;

        System.out.println(String.format("Lateral Surface Area – %.2f", lateralSurfaceArea));
    }

    public void getVolume() {
        double volume = this.length * this.width * this.height;

        System.out.println(String.format("Volume – %.2f", volume));
    }
}
