package p02_methodOverriding.models;

public class Rectangle extends RectangleShape {

    private double width;
    private double height;

    public Rectangle(double width, double height) {
        this.setWidth(width);
        this.setHeight(height);
    }

    private void setWidth(double width) {
        this.width = width;
    }

    private void setHeight(double height) {
        this.height = height;
    }

    @Override
    public double area() {
        return this.width * this.height;
    }
}
