package com.company;
//only 50/100, need more debugging
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.TreeMap;

public class DragonArmy {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        LinkedHashMap<String, TreeMap<String, ArrayList<Integer>>> gameDragons = new LinkedHashMap<>();
        LinkedHashMap<String, ArrayList<Double>> colorTypeAndAverage = new LinkedHashMap<>();

        int brGold = 0;
        int brRed = 0;
        int brBlue = 0;
        int brBlack = 0;

        int n = Integer.parseInt(reader.readLine());
        for (int i = 1; i <= n; i++) {

            String[] input = reader.readLine().split(" ");
            String colorType = input[0];
            String dragonName = input[1];

            int[] dha = GetDamageHealthArmor(input);
            int damage = dha[0];
            int health = dha[1];
            int armor = dha[2];

            if (!gameDragons.containsKey(colorType) || (gameDragons.containsKey(colorType) && !gameDragons.get(colorType).containsKey(dragonName))) {
                if (colorType.equals("Gold")) {
                    brGold++;
                } else if (colorType.equals("Red")) {
                    brRed++;
                } else if (colorType.equals("Blue")) {
                    brBlue++;
                } else if (colorType.equals("Black")) {
                    brBlack++;
                }
            } else if (gameDragons.containsKey(colorType) && gameDragons.get(colorType).containsKey(dragonName)) {
                if (colorType.equals("Gold")) {
                    brGold--;
                } else if (colorType.equals("Red")) {
                    brRed--;
                } else if (colorType.equals("Blue")) {
                    brBlue--;
                } else if (colorType.equals("Black")) {
                    brBlack--;
                }
            }

            AddDragonGameDataInLinkedHashMap(gameDragons, colorType, dragonName, damage, health, armor);
        }

        AddColorTypeAndAverageSum(colorTypeAndAverage, gameDragons);
        CalculateAverageStats(colorTypeAndAverage, brGold, brRed, brBlue, brBlack );
        PrintMethod(colorTypeAndAverage, gameDragons);

    }

    private static void AddColorTypeAndAverageSum(LinkedHashMap<String, ArrayList<Double>> colorTypeAndAverage, LinkedHashMap<String, TreeMap<String, ArrayList<Integer>>> gameDragons)
    {
        for (String color : gameDragons.keySet()) {
            for (String dragon : gameDragons.get(color).keySet()) {

                if (!colorTypeAndAverage.containsKey(color)) {
                    colorTypeAndAverage.put(color, new ArrayList<>());

                    double damage = gameDragons.get(color).get(dragon).get(0);
                    double health = gameDragons.get(color).get(dragon).get(1);
                    double armor = gameDragons.get(color).get(dragon).get(2);

                    ArrayList<Double> averageStatsList = new ArrayList<>();
                    averageStatsList.add(damage);
                    averageStatsList.add(health);
                    averageStatsList.add(armor);

                    colorTypeAndAverage.put(color, averageStatsList);
                } else {
                    double damage = colorTypeAndAverage.get(color).get(0);
                    double health = colorTypeAndAverage.get(color).get(1);
                    double armor = colorTypeAndAverage.get(color).get(2);

                    damage += gameDragons.get(color).get(dragon).get(0);
                    health += gameDragons.get(color).get(dragon).get(1);
                    armor += gameDragons.get(color).get(dragon).get(2);

                    ArrayList<Double> averageStatsList = new ArrayList<>();
                    averageStatsList.add(damage);
                    averageStatsList.add(health);
                    averageStatsList.add(armor);

                    colorTypeAndAverage.put(color, averageStatsList);
                }
            }
        }
    }

    private static void PrintMethod(LinkedHashMap<String, ArrayList<Double>> colorTypeAndAverage, LinkedHashMap<String, TreeMap<String, ArrayList<Integer>>> gameDragons) {
        for (String type : colorTypeAndAverage.keySet()) {

                double d = colorTypeAndAverage.get(type).get(0);
                double h = colorTypeAndAverage.get(type).get(1);
                double a = colorTypeAndAverage.get(type).get(2);

                System.out.println(String.format("%s::(%.2f/%.2f/%.2f)", type, d, h, a));

                for (String dragon : gameDragons.get(type).keySet()) {
                    int dam = gameDragons.get(type).get(dragon).get(0);
                    int heal = gameDragons.get(type).get(dragon).get(1);
                    int arm = gameDragons.get(type).get(dragon).get(2);

                    System.out.println(String.format("-%s -> damage: %d, health: %d, armor: %d", dragon, dam, heal, arm));
                }
            }
        }

    private static void CalculateAverageStats(LinkedHashMap<String, ArrayList<Double>> colorTypeAndAverage, int brGold, int brRed, int brBlue, int brBlack) {
        for (String colorType : colorTypeAndAverage.keySet()) {

                if (colorType.equals("Red")) {
                    AverageDragons(colorTypeAndAverage, colorType, brRed);
                } else if (colorType.equals("Gold")) {
                    AverageDragons(colorTypeAndAverage, colorType, brGold);
                } else if (colorType.equals("Blue")) {
                    AverageDragons(colorTypeAndAverage, colorType, brBlue);
                } else if (colorType.equals("Black")) {
                    AverageDragons(colorTypeAndAverage, colorType, brBlack);
                }
            }
        }

    private static void AverageDragons(LinkedHashMap<String, ArrayList<Double>> colorTypeAndAverage, String colorType, int br)
    {
        double newDamage = colorTypeAndAverage.get(colorType).get(0) / br;
        double newHealth = colorTypeAndAverage.get(colorType).get(1) / br;
        double newArmor = colorTypeAndAverage.get(colorType).get(2) / br;

        colorTypeAndAverage.get(colorType).clear();

        ArrayList<Double> averageStatsList = new ArrayList<>();
        averageStatsList.add(newDamage);
        averageStatsList.add(newHealth);
        averageStatsList.add(newArmor);

        colorTypeAndAverage.replace(colorType, averageStatsList);
    }

    private static void AddDragonGameDataInLinkedHashMap(LinkedHashMap<String, TreeMap<String, ArrayList<Integer>>> gameDragons, String colorType, String dragonName, int damage, int health, int armor)
    {
        if (!gameDragons.containsKey(colorType)) {
            gameDragons.put(colorType, new TreeMap<>());

            ArrayList<Integer> statsList = new ArrayList<Integer>();
            statsList.add(damage);
            statsList.add(health);
            statsList.add(armor);

            gameDragons.get(colorType).put(dragonName, statsList);
            return;
        } else if (gameDragons.containsKey(colorType) && !gameDragons.get(colorType).containsKey(dragonName))
        {
            ArrayList<Integer> statsList = new ArrayList<Integer>();
            statsList.add(damage);
            statsList.add(health);
            statsList.add(armor);

            gameDragons.get(colorType).put(dragonName, statsList);
            return;
        }
        if (gameDragons.containsKey(colorType) && gameDragons.get(colorType).containsKey(dragonName)){
            gameDragons.replace(colorType, new TreeMap<>());

            ArrayList<Integer> statsList = new ArrayList<Integer>();
            statsList.add(damage);
            statsList.add(health);
            statsList.add(armor);

            gameDragons.get(colorType).replace(dragonName, statsList);
            return;
        }
    }

    private static int[] GetDamageHealthArmor(String[] input) {
        int[] dha = new int[3];
        try {
            dha[0] = Integer.parseInt(input[input.length - 3]);
        } catch (Exception e) {
            dha[0] = 45;
        }
        try {
            dha[1] = Integer.parseInt(input[input.length - 2]);
        } catch (Exception e) {
            dha[1] = 250;
        }
        try {
            dha[2] = Integer.parseInt(input[input.length - 1]);
        } catch (Exception e) {
            dha[2] = 10;
        }
        return dha;
    }
}
