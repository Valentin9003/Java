package p03_shapes.models;

public abstract class Shape implements IShape {

    private double perimeter;
    private double area;

    public Shape() {
    }

    public double getPerimeter() {
        return this.perimeter;
    }

    protected void setPerimeter(double perimeter) {
        this.perimeter = perimeter;
    }

    public double getArea() {
        return this.area;
    }

    protected void setArea(double area) {
        this.area = area;
    }

    @Override
    public abstract void calculatePerimeter();

    @Override
    abstract public void calculateArea();
}
