package com.company;

import java.util.Scanner;

public class CountTheIntegers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int br = 0;

        while (scanner.hasNextInt()){
            scanner.nextInt();
            br++;
        }
        System.out.println();
        System.out.println(br);
        scanner.close();
    }
}
