package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class HornetArmada {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        LinkedHashMap<String,Long> legionActivity = new LinkedHashMap<>();
        LinkedHashMap<String, HashMap<String, Long>> legionSoldiersTC = new LinkedHashMap<>();


        int n = Integer.parseInt(reader.readLine());
        for (int i = 0; i < n; i++)
        {
            List<String> inputData = new ArrayList<>(Arrays.asList(reader.readLine().split("[\\s=\\->:]+")));
            UpdateLegions(legionSoldiersTC, legionActivity, inputData);
        }

        String[] printCommand = reader.readLine().split("\\\\");

        if (printCommand.length == 1) {
            // In this case, you must print all legions which have the given soldier type, with last activity, and legion name.
            // The legions must be printed in descending order of their activity.
            PrintActivityAndLegions(legionActivity, legionSoldiersTC, printCommand);
        } else {
            //In this  case, you must print all legions, and the count of soldiers they have from the given soldier type,
            // who’s last activity is LOWER than the given activity. The legions must be printed in descending order by soldier count.
            PrintLegionsAndCountOfSoldiers(legionActivity, legionSoldiersTC, printCommand);
        }
    }

    private static void PrintLegionsAndCountOfSoldiers(LinkedHashMap<String, Long> legionActivity, LinkedHashMap<String, HashMap<String, Long>> legionSoldiersTC, String[] printCommand)
    {
        long activity = Long.parseLong(printCommand[0]);
        String soldierType = printCommand[1];

        LinkedHashMap<String, Long> resultLegionCount = new LinkedHashMap<>();
        for (String legion : legionActivity.keySet()) {
            if (legionActivity.get(legion) < activity) {
                if (legionSoldiersTC.get(legion).containsKey(soldierType))
                resultLegionCount.put(legion, legionSoldiersTC.get(legion).get(soldierType));
            }
        }
        resultLegionCount.entrySet().stream().sorted((x1,x2) -> x2.getValue().compareTo(x1.getValue())).forEach( x -> {
            System.out.println(x.getKey() + " -> " + x.getValue());
        });
    }

    private static void PrintActivityAndLegions(LinkedHashMap<String, Long> legionActivity, LinkedHashMap<String, HashMap<String, Long>> legionSoldiersTC, String[] printCommand)
    {
        LinkedHashMap<String, Long> result = new LinkedHashMap<>();
        String soldiersType = printCommand[0];
        for (String legion : legionSoldiersTC.keySet()) {
            if (legionSoldiersTC.get(legion).containsKey(soldiersType)) {
                result.put(legion, legionActivity.get(legion));
            }
        }
        result.entrySet().stream().sorted((x1,x2) -> x2.getValue().compareTo(x1.getValue())).forEach( x-> {
            System.out.println(x.getValue() + " : " + x.getKey());
        });
    }

    private static void UpdateLegions(LinkedHashMap<String, HashMap<String, Long>> legionSoldiersTC, LinkedHashMap<String, Long> legionActivity, List<String> inputData)
    {
        long activity = Long.parseLong(inputData.get(0));
        String legionName = inputData.get(1);
        String soldiersType = inputData.get(2);
        Long soldiersCount = Long.parseLong(inputData.get(3));

        if (!legionActivity.containsKey(legionName)) {
            legionActivity.put(legionName, activity);

            legionSoldiersTC.put(legionName, new HashMap<>());
            legionSoldiersTC.get(legionName).put(soldiersType, soldiersCount);
        }
        else {
          if (!legionSoldiersTC.get(legionName).containsKey(soldiersType)) {
              if (activity > legionActivity.get(legionName)) {
                  legionActivity.replace(legionName, activity);
              }

              legionSoldiersTC.get(legionName).put(soldiersType, soldiersCount);
          } else if (legionSoldiersTC.get(legionName).containsKey(soldiersType)) {
              if (activity > legionActivity.get(legionName)) {
                  legionActivity.replace(legionName, activity);
              }

              long currentSoldiers = legionSoldiersTC.get(legionName).get(soldiersType);
              long newAmountOfSoldiers = currentSoldiers + soldiersCount;
              legionSoldiersTC.get(legionName).replace(soldiersType, newAmountOfSoldiers);
          }
        }
    }
}
