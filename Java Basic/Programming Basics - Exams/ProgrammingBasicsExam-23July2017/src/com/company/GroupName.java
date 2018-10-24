package com.company;

import java.util.Scanner;

public class GroupName {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char bigA = scanner.nextLine().charAt(0);
        char smallA = scanner.nextLine().charAt(0);
        char smallB = scanner.nextLine().charAt(0);
        char smallC = scanner.nextLine().charAt(0);
        int number = Integer.parseInt(scanner.nextLine());

        int br = 0;

        for (char i = 'A'; i <= bigA ; i++) {
            for (char j = 'a'; j <= smallA ; j++) {
                for (char k = 'a'; k <= smallB ; k++) {
                    for (char l = 'a'; l <= smallC ; l++) {
                        for (int m = 0; m <= number ; m++) {

                            if (i == bigA && j == smallA && k == smallB && l == smallC && m == number) {
                                break;
                            }
                            br++;
                        }
                    }
                }
            }
        }
        System.out.println(br);
    }
}
