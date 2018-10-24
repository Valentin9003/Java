package p03_animalFarm;

import p03_animalFarm.models.Chicken;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String chickenName = reader.readLine();
        int chickenYears = Integer.parseInt(reader.readLine());

        Chicken chicken = null;
        try {
            chicken = new Chicken(chickenName, chickenYears);
            System.out.println(chicken);
        } catch (IllegalArgumentException iae) {
            System.out.println(iae.getMessage());
        }

    }
}
