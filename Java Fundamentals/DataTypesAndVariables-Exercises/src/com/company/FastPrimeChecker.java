package com.company;

import java.util.Scanner;

public class FastPrimeChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());

        for (int index = 2; index <= number; index++) {

            boolean isTrue = true;

                for (int divisionNumber = 2; divisionNumber <= Math.sqrt(index); divisionNumber++) {

                    if (index % divisionNumber == 0)
                    {
                        isTrue = false;
                        break;
                    }
                }
                String bool = Boolean.toString(isTrue);
                bool = Character.toString(bool.charAt(0)).toUpperCase()+bool.substring(1);

            System.out.println(index + " -> " + bool);
        }
    }
}
