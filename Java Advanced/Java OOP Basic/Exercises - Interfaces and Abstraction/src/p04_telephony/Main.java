package p04_telephony;

import p04_telephony.models.Smartphone;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] numbers = reader.readLine().split("\\s+");
        String[] urls = reader.readLine().split("\\s+");

        Smartphone smartphone = new Smartphone();
        for (String number : numbers) {
            try {
                System.out.println(smartphone.call(number));
            } catch (IllegalArgumentException iae) {
                System.out.println(iae.getMessage());
            }
        }

        for (String url : urls) {
            try {
                System.out.println(smartphone.visit(url));
            } catch (IllegalArgumentException iae) {
                System.out.println(iae.getMessage());
            }
        }
    }
}
