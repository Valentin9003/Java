import java.text.DecimalFormat;
import java.util.Scanner;

public class SmartLili {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("####.00");

        int years = Integer.parseInt(scanner.nextLine());   // [1...77]
        double priceP = Double.parseDouble(scanner.nextLine());   // [1.00....10 000]
        int toyPrice = Integer.parseInt(scanner.nextLine());   // [0.....40]
        int br = 0;
        int brEvenYears = 0;
        double money = 0;

        for (int i = 1; i <= years; i++) {
            if (i % 2 == 0) {
                brEvenYears++;
                money += (brEvenYears * 10) - 1;
            } else {
                br++;
            }
        }
        money += br * toyPrice;
        if (money >= priceP) {
            System.out.println("Yes! " + df.format(money - priceP));
        } else {
            System.out.println("No! " + df.format(priceP - money));
        }
    }
}
