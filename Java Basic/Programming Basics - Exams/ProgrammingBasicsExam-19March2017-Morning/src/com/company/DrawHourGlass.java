package com.company;

import java.util.Scanner;

public class DrawHourGlass {
    private static String print(String element, int count) {
        return new String(new char[count]).replace("\0", element);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int hightWeigh = 2 * n + 1;

        if ((n >= 3) && (n <= 51) && (n % 2 != 0)) {                                  // Проверка за входа на N

            System.out.printf("%s%n", print("*", hightWeigh));                // Първи ред
            int space = hightWeigh - 4;
            System.out.printf(".*%s*.%n", print(" ", space));                 // Втори Ред

            int brPtUp = 2;
            int brSimbolsUp = hightWeigh - (brPtUp * 2 + 2);
            for (int i = 0; i < (n - 2); i++) {                                       // Горна част
                System.out.printf("%s*%s*%s%n",
                        print(".", brPtUp),
                        print("@", brSimbolsUp),
                        print(".", brPtUp));
                brPtUp++;
                brSimbolsUp -= 2;
            }

            int centerPt = (hightWeigh - 1) / 2;
            System.out.printf("%s*%s%n",                                              // Среден Ред
                    print(".", centerPt),
                    print(".", centerPt));

            int brPtDown = brPtUp -1;
            for (int i = 0; i < (n - 2); i++) {                                       // Долна част
                System.out.printf("%s*%s@%s*%s%n",
                        print(".", brPtDown),
                        print(" ", i),
                        print(" ", i),
                        print(".", brPtDown));
                brPtDown--;
            }

            System.out.printf(".*%s*.%n", print("@", space));                 // Пред - последен ред
            System.out.printf("%s%n", print("*", hightWeigh));                // Последен ред

        } else {
            System.out.println("Wrong input! N can be only Odd number in [3..51]");   // При неправилно въведено N
        }
    }
}
