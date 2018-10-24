package p02_methodOverriding.models;

public class Square extends RectangleShape {

    private double side;

    public Square(double side) {
        this.setSide(side);
    }

    private void setSide(double side) {
        this.side = side;
    }

    @Override
    public double area() {
        return Math.pow(side, 2);
    }
}
