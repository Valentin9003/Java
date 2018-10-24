package com.company;
// 100/100 in judge
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class DragonArmy2 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        // TreeMap orders exam score (increasingly) all students (alphabetically).Allows multiple entries per a key
        LinkedHashMap<String, TreeMap<String, LinkedHashMap<String, Integer>>> typeNamesStatsValue = new LinkedHashMap<>();
        for (int i = 0; i < n; i++) {
            String[] inputData = reader.readLine()
                    .trim()
                    .split("\\W+");

            // Default values are as follows: health 250, damage 45, and armor 10
            int damage = 45;
            int health = 250;
            int armor = 10;

            // {type} {name} {damage} {health} {armor}.
            String type = inputData[0];
            String name = inputData[1];
            if (!inputData[2].equals("null")) {
                damage = Integer.parseInt(inputData[2]);
            }
            if (!inputData[3].equals("null")) {
                health = Integer.parseInt(inputData[3]);
            }
            if (!inputData[4].equals("null")) {
                armor = Integer.parseInt(inputData[4]);
            }

            if (!typeNamesStatsValue.containsKey(type)) {
                typeNamesStatsValue.put(type, new TreeMap<>());
            }
            if (!typeNamesStatsValue.get(type)
                    .containsKey(name)) {
                typeNamesStatsValue.get(type)
                        .put(name, new LinkedHashMap<>());

            }
            typeNamesStatsValue.get(type)
                    .get(name)
                    .put("damage", damage);
            typeNamesStatsValue.get(type)
                    .get(name)
                    .put("health", health);
            typeNamesStatsValue.get(type)
                    .get(name)
                    .put("armor", armor);
        }

        printResult(typeNamesStatsValue);

    }

    private static void printResult(LinkedHashMap<String, TreeMap<String, LinkedHashMap<String, Integer>>> typeNamesStatsValue) {
        for (String type : typeNamesStatsValue.keySet()) {
            //For each type, print average stats of its dragons in format {Type}::({damage}/{health}/{armor})
            System.out.printf("%s::", type);
            double averageDamage = getAveratgeState(typeNamesStatsValue, type, "damage");
            double averageHealth = getAveratgeState(typeNamesStatsValue, type, "health");
            double averageArmor = getAveratgeState(typeNamesStatsValue, type, "armor");
            System.out.printf("(%.2f/%.2f/%.2f)", averageDamage, averageHealth, averageArmor)
                    .println();
            for (String name : typeNamesStatsValue.get(type)
                    .keySet()) {
                //-Bazgargal -> damage: 100, health: 2500, armor: 25
                System.out.printf("-%s -> ", name);
                String result = typeNamesStatsValue.get(type)
                        .get(name)
                        .keySet()
                        .stream()
                        .map(state -> String.format("%s: %d", state, typeNamesStatsValue.get(type)
                                .get(name)
                                .get(state)))
                        .collect(Collectors.joining(", "));
                System.out.println(result);
            }
        }
    }

    private static double getAveratgeState(LinkedHashMap<String, TreeMap<String, LinkedHashMap<String, Integer>>> typeNamesStatsValue, String type, String entryState) {
        double averageState = 0;
        int countNames = typeNamesStatsValue.get(type)
                .size();
        for (String name : typeNamesStatsValue.get(type)
                .keySet()) {
            for (String state : typeNamesStatsValue.get(type)
                    .get(name)
                    .keySet()) {
                if (state.equals(entryState)) {
                    averageState += typeNamesStatsValue.get(type)
                            .get(name)
                            .get(state);
                }

            }
        }
        return averageState = averageState * 1.0 / countNames;
    }
}
