package com.company.borderControl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Society> societyList = new LinkedList<>();

        String inputLine = reader.readLine();
        while (!inputLine.equals("End")) {
            String[] tokens = inputLine.split("\\s+");
            addToScietyList(tokens, societyList);
            inputLine = reader.readLine();
        }

        String fakeId = reader.readLine();
        printDetainedId(societyList, fakeId);
    }

    private static void printDetainedId(List<Society> societyList, String fakeId) {
        societyList
                .stream()
                .filter(x -> x.getId().endsWith(fakeId))
                .forEach(d -> System.out.println(d.getId()));
    }

    private static void addToScietyList(String[] tokens, List<Society> societyList) {
        Society society = null;
        String id;
        switch (tokens.length) {
            case 2:
                String model = tokens[0];
                id = tokens[1];
                society = new Robot(model, id);
                break;
            case 3:
                String name = tokens[0];
                Integer age = Integer.parseInt(tokens[1]);
                id = tokens[2];
                society = new Citizen(name, age, id);
                break;
        }
        societyList.add(society);
    }
}
