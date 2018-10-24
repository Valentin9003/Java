package com.company.Problem8ShapesVolume;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ShapesVolumeMain {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] tokens = reader.readLine().split("\\s+");
        while (!tokens[0].equals("End")) {

            executeVolumeCalculator(tokens);

            tokens = reader.readLine().split("\\s+");
        }
    }

    private static void executeVolumeCalculator(String[] tokens) {
        String figure = tokens[0];
        switch (figure) {
            case "TrianglePrism":
                double baseSide = Double.valueOf(tokens[1]);
                double heightFromBaseSide = Double.valueOf(tokens[2]);
                double length = Double.valueOf(tokens[3]);

                TriangularPrism triangularPrism = new TriangularPrism(baseSide, heightFromBaseSide, length);
                VolumeCalculator.calculatingVolumeOfTriangularPrism(triangularPrism);
                break;

            case "Cube":
                double sideLength = Double.valueOf(tokens[1]);

                Cube cube = new Cube(sideLength);
                VolumeCalculator.calculatingVolumeOfCube(cube);
                break;

            case "Cylinder":
                double radius = Double.valueOf(tokens[1]);
                double height = Double.valueOf(tokens[2]);

                Cylinder cylinder = new Cylinder(radius, height);
                VolumeCalculator.calculatingVolumeOfCylinder(cylinder);
                break;
        }
    }
}
