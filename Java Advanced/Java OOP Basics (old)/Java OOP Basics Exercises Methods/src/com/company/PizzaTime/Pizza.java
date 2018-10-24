package com.company.PizzaTime;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Pizza {
    private String name;
    private Integer group;

    public TreeMap<Integer, List<String>> pizzaMethod(String... tokens) {
        TreeMap<Integer, List<String>> pizzaMap = new TreeMap<>();

        Pattern pattern = Pattern.compile("([0-9]+)(.+)");
        for (String token : tokens) {

            int currentGroup = 0;
            String name = "";

            Matcher matcher = pattern.matcher(token);
            if (matcher.find()) {
                currentGroup = Integer.valueOf(matcher.group(1));
                name = matcher.group(2);
            }

            if (!pizzaMap.containsKey(currentGroup)) {
                pizzaMap.put(currentGroup, new ArrayList<>());
                pizzaMap.get(currentGroup).add(name);
            } else {
                pizzaMap.get(currentGroup).add(name);
            }
        }

        for (Integer pizzaGroup : pizzaMap.keySet()) {
            System.out.print(pizzaGroup + " - ");
            System.out.println(String.join(", ", pizzaMap.get(pizzaGroup)));
        }

        return pizzaMap;
    }
}
