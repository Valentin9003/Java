package p10_mooD3;

import p10_mooD3.impl.ArchangelImpl;
import p10_mooD3.impl.BaseCharacterImpl;
import p10_mooD3.impl.DemonImpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static final String CHARACTER_TYPE_DEMON = "Demon";
    private static final String CHARACTER_TYPE_ARCHANGEL = "Archangel";

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] tokens = reader.readLine().split(" \\| ");
        String userName = tokens[0];
        String characterType = tokens[1];
        int level = Integer.parseInt(tokens[3]);

        BaseCharacterImpl character = null;
        switch (characterType) {
            case CHARACTER_TYPE_ARCHANGEL:
                int mana = Integer.parseInt(tokens[2]);
                character = new ArchangelImpl(userName, level, mana);
                break;
            case CHARACTER_TYPE_DEMON:
                double energy = Double.parseDouble(tokens[2]);
                character = new DemonImpl(userName, level, energy);
                break;
        }

        System.out.println(character);
    }
}
