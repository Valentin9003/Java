package com.company;

import java.util.Scanner;

public class RefactorSpecialNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = scanner.nextInt();

        for (int index = 1; index <= number; index++){
            int sum = 0;
            int actualNumber = index;
            String tF = "";

            while (index > 0){
                sum += index % 10;
                index = index / 10;
            }

            boolean trueFalse = (sum == 5) || (sum == 7) || (sum == 11);

            if (trueFalse){
                tF = "True";
            } else {
                tF = "False";
            }

            System.out.printf("%d -> " + tF + "%n", actualNumber);
            index = actualNumber;
        }

    }
}
