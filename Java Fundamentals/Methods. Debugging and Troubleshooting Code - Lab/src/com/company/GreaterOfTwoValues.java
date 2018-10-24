package com.company;

import java.util.Scanner;

public class GreaterOfTwoValues {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine().toLowerCase();
        if (input.equals("int"))
        {
            int first = Integer.parseInt(scanner.nextLine());
            int second = Integer.parseInt(scanner.nextLine());
            int outputLarger = GetIntMax(first, second);
            System.out.println(outputLarger);
        }
        else if (input.equals("char"))
        {
            char first = scanner.nextLine().charAt(0);
            char second = scanner.nextLine().charAt(0);
            char outputLarger = GetCharMax(first, second);
            System.out.println(outputLarger);
        }
        else
        {
            String first = scanner.nextLine();
            String second = scanner.nextLine();
            String outputLarger = GetStringMax(first, second);
            System.out.println(outputLarger);
        }

    }

    public static int GetIntMax(int first, int second)
    {
        return  Math.max(first, second);
    }

    public static String GetStringMax(String first, String second)
    {
        int result = first.compareTo(second);

        if (result <= 0) {
            return second;
        }  else {
            return first;
        }
    }

    public static char GetCharMax(char first, char second)
    {
        if (first >= second) {
            return first;
        } else {
            return second;
        }
    }
}
