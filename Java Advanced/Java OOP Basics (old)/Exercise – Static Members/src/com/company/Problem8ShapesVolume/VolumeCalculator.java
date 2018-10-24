package com.company.Problem8ShapesVolume;

public class VolumeCalculator {

    static void calculatingVolumeOfTriangularPrism(TriangularPrism triangularPrism) {
        double result = 0.5 * triangularPrism.getBaseSide()
                * triangularPrism.getHeightFromBaseSide()
                * triangularPrism.getLength();

        System.out.println(String.format("%.3f", result));
    }

    static void calculatingVolumeOfCube(Cube cube) {
        double result = Math.pow(cube.getSideLength(), 3);

        System.out.println(String.format("%.3f", result));
    }

    static void calculatingVolumeOfCylinder(Cylinder cylinder) {
        double result = Math.PI * Math.pow(cylinder.getRadius(), 2) * cylinder.getHeight();

        System.out.println(String.format("%.3f", result));
    }
}
