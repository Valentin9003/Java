package p05_codingTracker;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    @Author(name = "Pesho")
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Tracker.printMethodsByAuthor(Tracker.class);
    }
}
