package com.company;
// 80-100 in Judge
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NetherRealms {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<String> demonsList = new ArrayList<>(Arrays.asList(reader.readLine().split("[,\\s]+")));

        Collections.sort(demonsList);
        CalculateHealthDamageAndPrint(demonsList);
    }

    private static void CalculateHealthDamageAndPrint(List<String> demonsList)
    {
        for (String name : demonsList) {
            double damage = CalculateDamage(name);
            long health = CalculateHealth(name);

            System.out.println(String.format("%s - %d health, %.2f damage", name, health, damage));
        }
    }

    private static long CalculateHealth(String name)
    {
        long health = 0;
        Pattern pattern = Pattern.compile("[A-Za-z^%&$#@_?>~)`(<=|'\";:}{\\[\\]]");
        Matcher matcher = pattern.matcher(name);
        while (matcher.find()) {
            char ch = matcher.group().charAt(0);
            health += ch;
        }

        return health;
    }

    private static double CalculateDamage(String name)
    {
        double damage = 0.0;
        Pattern pattern = Pattern.compile("([+|\\-]?\\d+([.][0-9]+)?)");
        Matcher matcher = pattern.matcher(name);
        while (matcher.find()) {
            damage += Double.parseDouble(matcher.group());
        }

        Pattern patt = Pattern.compile("[/|*]");
        Matcher match = patt.matcher(name);
        while (match.find()) {
            if (match.group().equals("*")) {
                damage *= 2;
            } else if (match.group().equals("/")) {
                damage /= 2;
            }
        }

        return damage;
    }
}
