package com.company;

import java.util.Scanner;

public class Diamond {
    private static String print(String element, int count) {
        return new String(new char[count]).replace("\0", element);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        if (n % 2 == 0) {                                           //FIRST ROLL for even n
            int firstRowStars = 2;
            int firstRowLine = (n - firstRowStars) / 2;
            System.out.printf("%s%s%s%n",
                    print("-", firstRowLine),
                    print("*", firstRowStars),
                    print("-", firstRowLine));
        } else {                                                    //FIRST ROLL for odd n
            int firstRowStars = 1;
            int firstRowLine = (n - firstRowStars) / 2;
            System.out.printf("%s%s%s%n",
                    print("-", firstRowLine),
                    print("*", firstRowStars),
                    print("-", firstRowLine));
        }

        if (n % 2 == 0) {                                          // Even diamond half - first half
            int rolls = ((n -1) - 2)/2;
            int centerLines = 2;

            for (int i = 0; i < rolls ; i++) {
                int lines = (n - (2 + centerLines))/2;
                System.out.printf("%s*%s*%s%n",
                        print("-",lines),
                        print("-",centerLines),
                        print("-",lines));
                centerLines +=2;
            }

        } else {                                                   // Odd diamond half - first half
            int rolls = (n - 2)/2;
            int centerLines = 1;

            for (int i = 0; i < rolls ; i++) {
                int lines = (n - (2 + centerLines))/2;
                System.out.printf("%s*%s*%s%n",
                        print("-",lines),
                        print("-",centerLines),
                        print("-",lines));
                centerLines +=2;
            }
        }

        if (n > 2) {
            System.out.printf("*%s*%n", print("-", n - 2));         //CENTER ROLL
        }

        if (n % 2 == 0) {                                          // Even diamond half - second (down) half
            int rolls = ((n -1) - 2)/2;
            int centerLines = n - 4;

            for (int i = 0; i < rolls ; i++) {
                int lines = (n - (2 + centerLines))/2;
                System.out.printf("%s*%s*%s%n",
                        print("-",lines),
                        print("-",centerLines),
                        print("-",lines));
                centerLines -=2;
            }

        } else {                                                   // Odd diamond half - second (down) half
            int rolls = (n - 2)/2;
            int centerLines = n - 4;

            for (int i = 0; i < rolls ; i++) {
                int lines = (n - (2 + centerLines))/2;
                System.out.printf("%s*%s*%s%n",
                        print("-",lines),
                        print("-",centerLines),
                        print("-",lines));
                centerLines -=2;
            }
        }

        if (n > 2) {
            if (n % 2 == 0) {                                           //LAST ROLL for even n
                int firstRowStars = 2;
                int firstRowLine = (n - firstRowStars) / 2;
                System.out.printf("%s%s%s",
                        print("-", firstRowLine),
                        print("*", firstRowStars),
                        print("-", firstRowLine));
            } else {                                                    //LAST ROLL for odd n
                int firstRowStars = 1;
                int firstRowLine = (n - firstRowStars) / 2;
                System.out.printf("%s%s%s",
                        print("-", firstRowLine),
                        print("*", firstRowStars),
                        print("-", firstRowLine));
            }
        }
    }
}

