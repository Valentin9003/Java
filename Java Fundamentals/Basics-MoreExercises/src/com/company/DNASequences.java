package com.company;

import java.util.Scanner;

public class DNASequences {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int matchSum = Integer.parseInt(scanner.nextLine());
        int br = 0;

        for (int i = 1; i <= 4 ; i++) {
            for (int j = 1; j <=4 ; j++) {
                for (int k = 1; k <=4 ; k++) {

                    System.out.print(NumToLetter(i,j,k, matchSum) + " ");
                   br++;

                   if (br % 4 == 0) {
                       System.out.println();
                   }
                }
            }
        }


    }

    private static String NumToLetter(int i, int j, int k, int matchSum)
    {
        String letter1 = "";
        String letter2 = "";
        String letter3 = "";
        if (i == 1) {
            letter1 = "A";
        } else if (i == 2) {
            letter1 = "C";
        } else if (i == 3) {
            letter1 = "G";
        } else if (i == 4) {
            letter1 = "T";
        }
        if (j == 1) {
            letter2 = "A";
        } else if (j == 2) {
            letter2 = "C";
        } else if (j == 3) {
            letter2 = "G";
        } else if (j == 4) {
            letter2 = "T";
        }
        if (k == 1) {
            letter3 = "A";
        } else if (k == 2) {
            letter3 = "C";
        } else if (k == 3) {
            letter3 = "G";
        } else if (k == 4) {
            letter3 = "T";
        }

        int sum = i + j + k;
        String output = " ";

        if (sum >= matchSum) {
            output = "O"+ letter1 + letter2 + letter3 + "O";
        } else {
            output = "X"+ letter1 + letter2 + letter3 + "X";
        }

        return output;
    }
}
