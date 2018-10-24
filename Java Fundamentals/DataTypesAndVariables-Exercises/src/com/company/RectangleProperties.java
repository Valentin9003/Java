package com.company;

import java.text.DecimalFormat;
import java.util.Scanner;

public class RectangleProperties {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("####.#############");

        double width = Double.parseDouble(scanner.nextLine());
        double height = Double.parseDouble(scanner.nextLine());

        double perimeter = 2 * (width + height);
        double area = width * height;
        double diagonal = Math.sqrt((width * width + height * height));

        System.out.println(df.format(perimeter));
        System.out.println(df.format(area));
        System.out.println(df.format(diagonal));
    }
}
