package com.company;

import java.util.Scanner;

public class DrawAxe {
    private static String print(String element, int count) {
        return new String(new char[count]).replace("\0", element);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int weigh = 5 * n;
        int firstRowLeftLines = n * 3;
        int UpRows = n;
        int centerAndDownRows = n / 2;

        for (int i = 0; i < n; i++) {                                             // UP PAST
            int rightLines = weigh - (firstRowLeftLines + 2 + i);
            System.out.printf("%s*%s*%s%n",
                    print("-", firstRowLeftLines),
                    print("-", i),
                    print("-", rightLines));
        }
        int centralsStars = firstRowLeftLines + 1;
        int centerLines = n - 1;
        int centerRightLines = weigh - (centralsStars + centerLines + 1);

        for (int i = 1; i <= centerAndDownRows ; i++) {                                           // CENTRAL PAST
            System.out.printf("%s%s*%s%n",
                    print("*", centralsStars),
                    print("-", centerLines),
                    print("-", centerRightLines));
        }
        int brLeftLines = firstRowLeftLines;
        int brCentralLines = centerLines;
        int brRightLines = centerRightLines;
        for (int i = 1; i < centerAndDownRows ; i++) {                                  // DOWN PAST
            System.out.printf("%s*%s*%s%n",
                    print("-", brLeftLines),
                    print("-", brCentralLines),
                    print("-", brRightLines));
            brLeftLines-- ;
            brCentralLines += 2 ;
            brRightLines-- ;

        }
        int lastRowStars = weigh - (brLeftLines + brRightLines);
        System.out.printf("%s%s%s",                                                // LAST ROW
                print("-", brLeftLines),
                print("*", lastRowStars),
                print("-", brRightLines));
    }
}

