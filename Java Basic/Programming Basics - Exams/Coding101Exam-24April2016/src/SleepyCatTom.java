import java.util.Scanner;

public class SleepyCatTom {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int days = Integer.parseInt(scanner.nextLine()); // pochivni dni na stopanina
        int year = 365;      // dni v godinata
        int norma = 30000;   // normata na Tom za da se naspi dobre
        int timeForPlay;     //        Когато е на работа, стопанинът му си играе с него по 63 минути на ден.
        //        Когато почива, стопанинът му си играе с него по 127 минути на ден.

        timeForPlay = (365 - days) * 63 + days * 127;

        if (timeForPlay > norma) {
            System.out.println("Tom will run away");
            System.out.println((int)((timeForPlay - norma) / 60) + " hours and " + (int)(timeForPlay % 60)
                    + " minutes more for play");
        } else {
            System.out.println("Tom sleeps well");
            System.out.println((int)((norma - timeForPlay) / 60) + " hours and "
                    + (int)((norma - timeForPlay) % 60) + " minutes less for play" );
        }

    }
}
