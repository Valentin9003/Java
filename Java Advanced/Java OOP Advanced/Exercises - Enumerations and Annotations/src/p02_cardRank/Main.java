package p02_cardRank;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Card Ranks:");
        for (CardRank rank : CardRank.values()) {
            System.out.println(String.format("Ordinal value: %d; Name value: %s",
                    rank.ordinal(),
                    rank.name()));
        }
    }
}
