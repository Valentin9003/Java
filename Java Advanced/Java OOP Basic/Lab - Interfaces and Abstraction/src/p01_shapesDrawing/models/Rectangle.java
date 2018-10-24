package p01_shapesDrawing.models;

public class Rectangle implements Drawable {

    private int width;
    private int height;

    public Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    @Override
    public void draw() {
        for (int i = 0; i < this.getHeight() ; i++) {
            System.out.println("*");
            for (int j = 1; j < this.getWidth() - 1; j++) {
                System.out.println(" ");
                if (i == 0 || i == (this.getHeight() - 1)) {
                    System.out.println("*");
                } else {
                    System.out.println(" ");
                }
            }
            System.out.println(" ");
            System.out.println("*");
            System.out.println();
        }
    }
}
