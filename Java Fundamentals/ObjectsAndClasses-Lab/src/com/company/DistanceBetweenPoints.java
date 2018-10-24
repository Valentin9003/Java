package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class DistanceBetweenPoints {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Point point1 = PointReader(reader.readLine());
        Point point2 = PointReader(reader.readLine());

        CalculatePointDistance(point1, point2);
    }

    private static void CalculatePointDistance(Point point1, Point point2)
    {
        int deltaX = point1.X - point2.X;
        int deltaY = point1.Y - point2.Y;
        double distance = Math.sqrt(deltaX * deltaX + deltaY * deltaY);

        System.out.println(String.format("%f", distance));
    }

    private static Point PointReader(String input)
    {
        int[] coords = Arrays.stream(input.split(" ")).mapToInt(Integer::valueOf).toArray();
        Point dis = new Point();
        dis.X = coords[0];
        dis.Y = coords[1];
        return dis;
    }

}
class Point
{
   public int X;
   public int Y;
    public int[] pointsArr;
}
