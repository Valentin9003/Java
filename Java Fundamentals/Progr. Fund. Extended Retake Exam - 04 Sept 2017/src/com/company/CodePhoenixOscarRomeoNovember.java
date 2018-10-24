package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class CodePhoenixOscarRomeoNovember {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        LinkedHashMap<String, List<String>> creatureSMate = new LinkedHashMap<>();

        String input = reader.readLine();
        while (!"Blaze it!".equals(input))
        {
            UpdateHashMap(creatureSMate, input);

            input = reader.readLine();
        }
        
        LinkedHashMap<String, Integer> resultMapCM = new LinkedHashMap<>();
        CreatResultMap(resultMapCM, creatureSMate);

        PrintResult(resultMapCM);
    }

    private static void PrintResult(LinkedHashMap<String, Integer> resultMapCM)
    {
        resultMapCM.entrySet().stream().sorted((x1,x2) -> x2.getValue().compareTo(x1.getValue())).forEach( x -> {
            System.out.println(x.getKey() + " : " + x.getValue());
        });
    }

    private static void CreatResultMap(LinkedHashMap<String, Integer> resultMapCM, LinkedHashMap<String, List<String>> creatureSMate)
    {
        for (String creature : creatureSMate.keySet()) {
            int count = 0;
            for (String squadMate : creatureSMate.get(creature)) {
                if (!creatureSMate.containsKey(squadMate)) {
                    count++;
                } else {
                    if (!creatureSMate.get(squadMate).contains(creature)) {
                        count++;
                    }
                }
            }
            resultMapCM.put(creature, count);
        }
    }

    private static void UpdateHashMap(LinkedHashMap<String, List<String>> creatureSMate, String input)
    {
        String[] creatMateArr = input.split(" -> ");
        String creature = creatMateArr[0];
        String squadMate = creatMateArr[1];

        creatureSMate.putIfAbsent(creature, new ArrayList<>());
        if (!creatureSMate.get(creature).contains(squadMate) && !creature.equals(squadMate)) {
            creatureSMate.get(creature).add(squadMate);
        }
    }
}

/*
The fire creatures are assembling in squads to fight The Evil Phoenix God. You have been tasked to determine which squad is the strongest,
 so it will be sent as The Vanguard.
You will begin receiving input lines containing information about fire creatures in the following format:
{creature} -> {squadMate}
The creature and the squadMate are strings. You should store every creature, and his squad mates. If the creature already exists,
 you should add the new squad mate to it.
•	If there is already a squad mate with the given name in the given creature’s squad, IGNORE that line of input.
•	If the given squad mate name is the same as the given creature, IGNORE that line of input.
The input sequence ends when you receive the command “Blaze it!”.
When that happens you must print the creatures ordered in descending order by count of squad mates.
Sounds simple right? But there is one little DETAIL.
If a particular creature has a squadMate, and that squadMate has that creature in his squadMates, you should NOT consider them as part of the count of squad mates.
Example:
Creature 1: Mozilla -> {Tony, Dony, Mony}
Creature 2: Tony -> {Mozilla, Franzilla, Godzilla}
Mozilla has 2 squad mates in total, because Tony also has Mozilla in his squad mates.
Tony has 2 squad mates in total, because Mozilla also has Tony in his squad mates.
Input
•	As input you will receive several input lines containing information about the fire creatures.
•	The input sequence ends when you receive the command “Blaze it!”.
Output
•	As output you must print each of the creatures the following information:
o	{creature} : {countOfSquadMates}
•	As it was stated above, mind the count of squad mates. If 2 creatures have themselves in their squad mates, they should NOT be counted.
Constrains
•	The creature and the squadMate will be strings which may contain any ASCII character.
•	There will be NO invalid input lines.
•	Allowed time / memory: 100ms / 16MB.

 */