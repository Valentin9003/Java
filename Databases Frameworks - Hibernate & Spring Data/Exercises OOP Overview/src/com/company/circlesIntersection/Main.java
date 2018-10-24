package com.company.circlesIntersection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Circle circle1 = new Circle();
        Circle circle2 = new Circle();
        circle1.input = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();
        circle2.input2 = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();

        double dist = CalculateDistance(circle1, circle2);
        IntersectionOfCircles(dist, circle1, circle2);
    }

    private static void IntersectionOfCircles(double dist, Circle circle1, Circle circle2)
    {
        if ((dist <= circle1.RadiusC1() + circle2.RadiusC2()))
        {
            System.out.println("Yes");
        } else
        {
            System.out.println("No");
        }
    }

    private static double CalculateDistance(Circle circle1, Circle circle2)
    {
        int pt1 = circle1.input[1] - circle2.input2[1];
        int pt2 = circle1.input[2] - circle2.input2[2];
        double dis = Math.sqrt(pt1 * pt1 + pt2 * pt2);
        return dis;
    }
}
