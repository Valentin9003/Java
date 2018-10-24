package p01_shapesDrawing.models;

public class Circle implements Drawable {

    private int radius;

    public Circle(int radius) {
        this.radius = radius;
    }

    public int getRadius() {
        return radius;
    }

    @Override
    public void draw() {
        double rIn = this.getRadius() - 0.4;
        double rOut = this.getRadius() + 0.4;

        for (double y = this.getRadius(); y >= -this.getRadius(); --y) {
            for (double x = -this.getRadius(); x < rOut; x += 0.5) {
                double value = x * x + y * y;
                if (value >= rIn * rIn && value <= rOut * rOut) {
                    System.out.println("*");
                } else {
                    System.out.println(" ");
                }
            }
            System.out.println();
        }
    }
}
