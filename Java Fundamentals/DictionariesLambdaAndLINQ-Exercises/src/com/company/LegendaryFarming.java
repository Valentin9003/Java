package com.company;

//Judge don't like the sorting for print

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.TreeMap;

public class LegendaryFarming {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        HashMap<String, Integer> resourses = new HashMap<>();
        TreeMap<String, Integer> junk = new TreeMap<>();

        resourses.put("shards", 0);
        resourses.put("fragments", 0);
        resourses.put("motes", 0);

        boolean notEnoughRss = true;
        while (notEnoughRss) {
            String[] inputRss = reader.readLine().toLowerCase().split(" ");

            for (int i = 0; i < inputRss.length; i += 2) {
                int quantity =Integer.parseInt(inputRss[i]);
                String material = inputRss[i + 1];

                if (resourses.containsKey(material)){
                    AddMaterials(resourses, material, quantity);

                    if (resourses.get(material) >= 250) {
                        EditMaterialsIfHaveObtainedItem(resourses, material);
                        String result = ObtainedItem(resourses, material);

                        System.out.println(String.format("%s obtained!", result));
                        notEnoughRss = false;
                        break;
                    }
                } else {
                    AddJunkMaterials(junk, material, quantity);
                }
            }
        }

        PrintResult(resourses, junk);

    }

    private static void PrintResult(HashMap<String, Integer> resourses, TreeMap<String, Integer> junk)
    {
        resourses.entrySet().stream().sorted((x,y) -> y.getValue().compareTo(x.getValue()))
                .forEach(rs -> {
                    System.out.println(String.format("%s: %d", rs.getKey(), rs.getValue())); });

        for (String material : junk.keySet()) {
            System.out.println(String.format("%s: %d", material, junk.get(material)));
        }
    }

    private static void AddJunkMaterials(TreeMap<String, Integer> junk, String material, int quantity)
    {
        if (!junk.containsKey(material)) {
            junk.put(material, quantity);
        } else {
            int quantityValue = junk.get(material);
            quantityValue += quantity;
            junk.replace(material, quantityValue);
        }
    }

    private static void AddMaterials(HashMap<String, Integer> resourses, String material, Integer quantity)
    {
        int rssValue = resourses.get(material);
        rssValue += quantity;
        resourses.replace(material, rssValue);
    }

    private static void EditMaterialsIfHaveObtainedItem(HashMap<String, Integer> resourses, String material)
    {
        int rssValue = resourses.get(material);
        rssValue -= 250;
        resourses.replace(material, rssValue);
    }

    private static String ObtainedItem(HashMap<String, Integer> resourses, String material)
    {
        String result = "";
        switch (material)
        {
            case "shards":
                result = "Shadowmourne";
                break;
            case "fragments":
                result = "Valanyr";
                break;
            case "motes":
                result = "Dragonwrath";
                break;
        }
        return result;
    }
}
