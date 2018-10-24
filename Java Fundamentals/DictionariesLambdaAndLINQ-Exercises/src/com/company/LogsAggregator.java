package com.company;

//40/100 -- Need more debugging..

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.TreeMap;

public class LogsAggregator {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        TreeMap<String, Integer> namesDuration = new TreeMap<>();
        TreeMap<String, String> ipName = new TreeMap<>();

        int n = Integer.parseInt(reader.readLine());
        for (int i = 0; i < n; i++) {

            String[] input = reader.readLine().split("\\s");
            String ip = input[0];
            String name = input[1];
            int duration = Integer.parseInt(input[2]);

            AddnamesAndDuration(namesDuration, name, duration);
            AddnamesAndIP(ipName, name, ip);


        }

        PrintMethod(namesDuration, ipName);

    }

    private static void PrintMethod(TreeMap<String, Integer> namesDuration, TreeMap<String, String> ipName)
    {
        for (String name : namesDuration.keySet()) {
            System.out.print(String.format("%s: %d ", name, namesDuration.get(name)));

            ArrayList<String> ipList = new ArrayList<>();
            for (String ip : ipName.keySet()) {
                if (ipName.get(ip).equals(name)) {
                    ipList.add(ip);
                }
            }
            System.out.print(ipList);
            System.out.println();
        }
    }

    private static void AddnamesAndIP(TreeMap<String, String> ipName, String name, String ip)
    {
        if (!ipName.containsKey(ip)) {
            ipName.put(ip, name);
        }
    }

    private static void AddnamesAndDuration(TreeMap<String, Integer> namesDuration, String name, int duration)
    {
        if (!namesDuration.containsKey(name)) {
            namesDuration.put(name, duration);
        } else {
            int value = namesDuration.get(name);
            value += duration;
            namesDuration.replace(name, value);
        }
    }
}
