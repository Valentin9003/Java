package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Hideout {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String map = reader.readLine();
        String[] tokens = reader.readLine().split(" ");

        while (true) {
            String searchedCharacter = tokens[0];
            int minimumCount = Integer.parseInt(tokens[1]);

            String rgx = "";
            if (searchedCharacter.equals("?") || searchedCharacter.equals(".") || searchedCharacter.equals("*")) {
                rgx += "[\\" + searchedCharacter + "]{" + minimumCount + ",}";
            } else if (searchedCharacter.equals("\\\\")) {
                rgx += "[\\\\]{" + minimumCount + ",}";
            } else {
                rgx += "[" + searchedCharacter + "]{" + minimumCount + ",}";
            }

            Pattern pattern = Pattern.compile(rgx);
            Matcher matcher = pattern.matcher(map);

            if (matcher.find()) {
                int size = matcher.group().length();
                int index = map.indexOf(matcher.group());

                System.out.println(String.format("Hideout found at index %d and it is with size %d!", index, size));
                return;
            } else {
                tokens = reader.readLine().split(" ");
            }

        }
    }
}
