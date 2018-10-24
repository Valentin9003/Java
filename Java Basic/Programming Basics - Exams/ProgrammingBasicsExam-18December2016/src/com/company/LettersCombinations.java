package com.company;

import java.util.Scanner;

public class LettersCombinations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char startLetter = scanner.nextLine().charAt(0);
        char endLetter = scanner.nextLine().charAt(0);
        char ignoreLetter = scanner.nextLine().charAt(0);

        int combinationsFound = 0;

        char[] combinationArray = new char[4];
        combinationArray[3] = ' ';

        for (char i = startLetter; i <= endLetter; i++) {
            if (i != ignoreLetter) {
                combinationArray[0] = i;
                for (char j = startLetter; j <= endLetter; j++) {
                    if (j != ignoreLetter) {
                        combinationArray[1] = j;
                        for (char k = startLetter; k <= endLetter; k++) {
                            if (k != ignoreLetter) {
                                combinationArray[2] = k;
                                System.out.print(combinationArray);
                                combinationsFound++;
                            }
                        }
                    }
                }
            }
        }

        System.out.println(combinationsFound);

    }
}
