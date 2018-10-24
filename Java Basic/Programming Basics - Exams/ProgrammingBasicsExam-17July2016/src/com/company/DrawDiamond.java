package com.company;

import java.util.Scanner;

public class DrawDiamond {
    private static String print(String element, int count) {
        return new String(new char[count]).replace("\0", element);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());      // [4...32]

        int weigh = 5 * n;
        int heigh = 3 * n + 2;
        int firstRowStars = 3 * n;
        int firstRowHalfPoints = (weigh - firstRowStars) / 2;

        if (n >= 4 && n <= 32) {                           // Checking for n

            System.out.printf("%s%s%s%n",                  // FIRST ROW
                    print(".",firstRowHalfPoints),
                    print("*", firstRowStars),
                    print(".", firstRowHalfPoints));

            int brPointsInCenterUp = firstRowStars;
            int brPointsOutUp = firstRowHalfPoints - 1;
            for (int i = 1; i <= (n-1) ; i++) {              //UP PAST
                System.out.printf("%s*%s*%s%n",
                        print(".", brPointsOutUp),
                        print(".", brPointsInCenterUp),
                        print(".", brPointsOutUp));
                brPointsInCenterUp += 2;
                brPointsOutUp--;
            }

            System.out.printf("%s%n", print("*", weigh));            // CENTER ROW

            int brPtOutDown = 1;
            int brPtInDown = weigh - 4;
            for (int i = 1; i <= (n * 2) ; i++) {                            //DOWN PAST
                System.out.printf("%s*%s*%s%n",
                        print(".", brPtOutDown),
                        print(".", brPtInDown),
                        print(".", brPtOutDown));
                brPtOutDown++;
                brPtInDown -= 2;
            }
            int lastRowStars = n - 2;
            int lastRowHalfPt = (weigh - lastRowStars) / 2;
            System.out.printf("%s%s%s%n",                                    //LAST ROW
                    print(".", lastRowHalfPt),
                    print("*", lastRowStars),
                    print(".", lastRowHalfPt));
        }
    }
}
