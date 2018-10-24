import java.util.Scanner;

public class DrowStop {
    private static String print(String element, int count) {
        return new String(new char[count]).replace("\0", element);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());      // [3....1000]
        int highFigure = (n * 2) + 2;                      // visochina
        int weigh = 4 * n + 3;                             // shirochina
        int firstRowHalfPoints = n + 1;
        int firstRowLines = weigh - firstRowHalfPoints * 2;

        if (n >= 3 && n <= 1000) {

            System.out.printf("%s%s%s%n",                                  // FIRST ROW
                    print(".", firstRowHalfPoints),
                    print("_", firstRowLines),
                    print(".", firstRowHalfPoints));

            int brPoints = firstRowHalfPoints - 1;

            for (int i = 1; i <= n; i++) {                               // UP HALF
                int lines = weigh - (brPoints * 2) - 4;
                System.out.printf("%s//%s\\\\%s%n",
                        print(".", brPoints),
                        print("_", lines),
                        print(".", brPoints));
                brPoints--;
            }
            int centerHalfLines = (weigh - 9) / 2;
            System.out.printf("//%sSTOP!%s\\\\%n",                          // CENTER ROW with text "STOP!"
                    print("_", centerHalfLines),
                    print("_", centerHalfLines));

            System.out.printf("\\\\%s//%n",                          // FIRST ROW AFTER CENTER
                    print("_", (weigh - 4)));

            int brPointsDown = 1;
            for (int i = 1; i <= (n - 1); i++) {                           // DOWN HALF
                int lines = weigh - (brPointsDown * 2) - 4;
                System.out.printf("%s\\\\%s//%s%n",
                        print(".", brPointsDown),
                        print("_", lines),
                        print(".", brPointsDown));
                brPointsDown++;
            }
        }
    }
}
