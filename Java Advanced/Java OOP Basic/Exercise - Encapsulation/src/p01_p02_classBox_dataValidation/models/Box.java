package p01_p02_classBox_dataValidation.models;

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

    public String getSurfaceArea() {
        double surfaceArea =
                2 * this.length * this.width
                        + 2 * this.length * this.height
                        + 2 * this.width * this.height;

        return String.format("Surface Area - %.2f", surfaceArea);
    }

    public String getLateralSurfaceArea() {
        double lateralSurfaceArea = 2 * this.length * this.height + 2 * this.width * this.height;

        return String.format("Lateral Surface Area - %.2f", lateralSurfaceArea);
    }

    public String getVolume() {
        double volume = this.length * this.width * this.height;

        return String.format("Volume - %.2f", volume);
    }

    @Override
    public String toString() {
        StringBuilder resultBuilder = new StringBuilder();
        resultBuilder.append(this.getSurfaceArea())
                .append(System.lineSeparator())
                .append(this.getLateralSurfaceArea())
                .append(System.lineSeparator())
                .append(this.getVolume());

        return resultBuilder.toString();
    }
}
