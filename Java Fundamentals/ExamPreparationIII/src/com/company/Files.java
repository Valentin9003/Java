package com.company;

import sun.security.krb5.internal.PAData;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Files {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int number = Integer.parseInt(reader.readLine());
        ArrayList<String> inputList = new ArrayList<>();

        for (int i = 0; i < number; i++) {
            String input = reader.readLine();
            inputList.add(input);
        }
        List<String> comandsList = new ArrayList<>(Arrays.asList(reader.readLine().split(" in ")));
        //Check for valid root
        ArrayList<String> sortedList = new ArrayList<>();
        for (String str : inputList) {
            String[] check = str.split("\\\\");
            if (check[0].equals(comandsList.get(1))) {
                sortedList.add(str);
            }
        }
        inputList.clear();
        //check for valid filename.extension
        String pattCheck = "\\." + comandsList.get(0) + "";
        Pattern p = Pattern.compile(pattCheck);
        for (String str : sortedList) {
            Matcher matcher = p.matcher(str);
            if (matcher.find()) {
                inputList.add(str);
            }
        }
        //if after checking dont have valid roots or valid file extension
        if (inputList.size() == 0) {
            System.out.println("No");
            return;
        }
        sortedList.clear();

        TreeMap<String, Integer> filenameSize = new TreeMap<>();
        UpdateTreeMap(inputList, filenameSize);

        PrintResult(filenameSize);
    }

    private static void PrintResult(TreeMap<String, Integer> filenameSize)
    {
        filenameSize.entrySet().stream().sorted((x1, x2) -> x2.getValue().compareTo(x1.getValue())).forEach( x -> {
            System.out.println(x.getKey() + " - " + x.getValue() + " KB");
        });
    }

    private static void UpdateTreeMap(ArrayList<String> inputList, TreeMap<String, Integer> filenameSize)
    {
        for (String str : inputList) {
            String[] folder = str.split("\\\\");
            String [] fileSize = folder[folder.length - 1].split(";");
            String name = fileSize[0];
            int size = Integer.parseInt(fileSize[1]);

            if (!filenameSize.containsKey(name)) {
                filenameSize.put(name, size);
            }

        }
    }
}
