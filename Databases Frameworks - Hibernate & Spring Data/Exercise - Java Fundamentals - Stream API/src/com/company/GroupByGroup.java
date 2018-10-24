package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class GroupByGroup {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        TreeMap<Integer, List<Person>> database = new TreeMap<>();

        String inputLine = reader.readLine();
        while (!inputLine.equals("END")) {
            addInDatabase(database, inputLine);
            inputLine= reader.readLine();
        }

        extractAndPrintAllPersonsGroupByGroup(database);
    }

    private static void extractAndPrintAllPersonsGroupByGroup(TreeMap<Integer, List<Person>> database) {
        database
                .forEach((key, value) -> {
                    List<String> names = new ArrayList<>();
                    value.forEach(x -> names.add(x.getName()));

                    System.out.print(String.format("%d - ", key));
                    System.out.print(String.join(", ", names));
                    System.out.println();
                });
    }

    private static void addInDatabase(TreeMap<Integer, List<Person>> database, String inputLine) {
        String[] tokens = inputLine.split("\\s");
        String name = String.format("%s %s", tokens[0], tokens[1]);
        Integer group = Integer.parseInt(tokens[2]);

        try {
            Person person = new Person(name, group);
            if (database.containsKey(group)) {
                database.get(group).add(person);
            } else {
                database.putIfAbsent(group, new ArrayList<>());
                database.get(group).add(person);
            }
        } catch (IllegalArgumentException iae) {
            System.out.println(iae.getMessage());
        }
    }
}

class Person{
  private String name;
  private Integer group;

    public Person(String name, Integer group) {
        this.setName(name);
        this.setGroup(group);
    }

    private void setName(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.name = name;
    }

    private void setGroup(Integer group) {
        if (group < 0) {
            throw new IllegalArgumentException("Group cannot be negative");
        }
        this.group = group;
    }

    public String getName() {
        return name;
    }

    public Integer getGroup() {
        return group;
    }
}