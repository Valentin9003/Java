package p03_shapes.models;

public class Rectangle extends Shape {

    private double height;
    private double width;

    public Rectangle(double height, double width) {
        this.setHeight(height);
        this.setWidth(width);
    }

    private void setHeight(double height) {
        this.height = height;
    }

    private void setWidth(double width) {
        this.width = width;
    }

    public final double getHeight() {
        return this.height;
    }

    public final double getWidth() {
        return this.width;
    }

    @Override
    public void calculatePerimeter() {
        super.setPerimeter(2 * (this.getHeight() + this.getWidth()));
    }

    @Override
    public void calculateArea() {
        super.setArea(this.getWidth() * this.getHeight());
    }
}
