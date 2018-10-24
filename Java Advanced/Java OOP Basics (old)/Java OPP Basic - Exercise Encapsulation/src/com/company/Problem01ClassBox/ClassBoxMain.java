package com.company.problem01ClassBox;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;

public class ClassBoxMain {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        double length = Double.valueOf(reader.readLine());
        double width = Double.valueOf(reader.readLine());
        double height = Double.valueOf(reader.readLine());

        Class boxClass = Box.class;
        Field[] fields = boxClass.getDeclaredFields();
        System.out.println(Arrays.asList(fields)
                .stream()
                .filter(f -> Modifier.isPrivate(f.getModifiers())).count());

        try {
            Box box = new Box(length, width, height);

            box.getSurfaceArea();
            box.getLateralSurfaceArea();
            box.getVolume();
        } catch (IllegalArgumentException iae) {
            System.out.println(iae.getMessage());
        }
    }
}
