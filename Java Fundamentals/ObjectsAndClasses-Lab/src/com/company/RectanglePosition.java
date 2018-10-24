package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class RectanglePosition {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Rectangle r1 = ReadRectangle(reader.readLine());
        Rectangle r2 = ReadRectangle(reader.readLine());

        if (IsInside(r1, r2)) {
            System.out.println("Inside");
        } else {
            System.out.println("Not inside");
        }
    }

    private static boolean IsInside(Rectangle r1, Rectangle r2)
    {
        boolean isInside = false;
        if ((r1.Left >= r2.Left) && (r1.Right() <= r2.Right()) && (r1.Top <= r2.Top) && (r1.Bottom() <= r2.Bottom()))
        {
            isInside = true;
        }
        return isInside;
    }

    private static Rectangle ReadRectangle(String input)
    {
        //2 rows -> 4 integers: left, top, width and height.
        long[] rectangle = Arrays.stream(input.split(" ")).mapToLong(Long::valueOf).toArray();
        Rectangle rect = new Rectangle();
        rect.Left = rectangle[0];
        rect.Top = rectangle[1];
        rect.Width = rectangle[2];
        rect.Height = rectangle[3];
        return rect;
    }
}
class Rectangle
{
    long Left;
    long Top;
    long Width;
    long Height;

    public long Bottom() {
       return Top + Height;
}
    public long Right() {
        return  Left + Width;
    }

    public long CalcArea()
    {
        return Width * Height;
    }
}
