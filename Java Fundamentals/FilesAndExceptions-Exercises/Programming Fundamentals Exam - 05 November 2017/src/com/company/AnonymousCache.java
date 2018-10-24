package com.company;
// 100/100
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AnonymousCache {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        HashMap<String, Long> dataSetDataSize = new HashMap<>();
        HashMap<String, Long> bufferSS = new HashMap<>();

        HashMap<String, List<String>> dataSetDataKey = new HashMap<>();
        HashMap<String, List<String>> bufferSK = new HashMap<>();

        String input = reader.readLine();

        while (!input.equals("thetinggoesskrra")) {
            String[] inputArr = input.split(" \\| ");
            if (inputArr.length == 1) {
                String dataSet = inputArr[0];

                long value = 0;
                dataSetDataSize.putIfAbsent(dataSet, value);
                dataSetDataKey.putIfAbsent(dataSet, new ArrayList<>());
            }
            else {
                String dataSet = inputArr[1];
                String firstPast = inputArr[0];
                String[] arr = firstPast.split(" -> ");
                String dataKey = arr[0];
                long dataSize = Long.parseLong(arr[1]);

                if (!dataSetDataSize.containsKey(dataSet)) {
                    if (!bufferSS.containsKey(dataSet)) {
                        bufferSS.put(dataSet, dataSize);

                        bufferSK.put(dataSet, new ArrayList<>());
                        bufferSK.get(dataSet).add(dataKey);
                    } else {
                        long value = bufferSS.get(dataSet) + dataSize;
                        bufferSS.replace(dataSet, value);

                        bufferSK.get(dataSet).add(dataKey);
                    }
                }
                else if (dataSetDataSize.containsKey(dataSet)) {
                    long value = dataSetDataSize.get(dataSet) + dataSize;
                    dataSetDataSize.replace(dataSet, value);

                    dataSetDataKey.get(dataSet).add(dataKey);
                }
            }

            input = reader.readLine();
        }

        for (String dataSet : dataSetDataSize.keySet()) {
            if (dataSetDataSize.get(dataSet) == 0) {
                if (bufferSS.containsKey(dataSet)) {
                    dataSetDataSize.replace(dataSet, bufferSS.get(dataSet));
                    dataSetDataKey.get(dataSet).addAll(bufferSK.get(dataSet));
                }
            }
        }

        String key = "";
        long size = 0;
        for (String dataSet : dataSetDataSize.keySet()) {
            if (dataSetDataSize.get(dataSet) > size) {
                size = dataSetDataSize.get(dataSet);
                key = dataSet;
            }
        }

        Print(dataSetDataKey, dataSetDataSize, key);
    }

    private static void Print(HashMap<String, List<String>> dataSetDataKey, HashMap<String, Long> dataSetDataSize, String key)
    {
        if (key.length() > 0 && dataSetDataSize.containsKey(key)) {
            System.out.println("Data Set: " + key + ", Total Size: " + dataSetDataSize.get(key));

            List<String> resultKeys = new ArrayList<>();
            resultKeys.addAll(dataSetDataKey.get(key));

            for (String dataKey : resultKeys) {
                System.out.println("$." + dataKey);
            }
        }
    }
}

/*
The Anonymous are storing data on their dataservers about their activities. The CIA has higher the greatest hacker in the world – You.
 Your job is to extract their data and send it to the CIA. It won’t be an easy task, Get Ready!
You will receive several input lines in one of the following formats:
•	{dataSet}
•	{dataKey} -> {dataSize} | {dataSet}
The dataSet and dataKey are both strings. The dataSize is an integer. The dataSets hold dataKeys and their dataSizes.
If you receive only a dataSet you should add it. If you receive a dataKey and a dataSize, you should add them to the given dataSet.
And here’s where the fun begins. If you receive a dataKey and a dataSize, but the given dataSet does NOT exist, you should STORE
those keys and values in a cache. When the corresponding dataSet is added, you should check if the cache holds any keys and values
referenced to it, and you should add them to the dataSet.
You should end your program when you receive the command “thetinggoesskrra”.  At that point you should extract the dataSet from the
data with the HIGHEST dataSize (SUM of all its dataSizes), and you should print it.
NOTE: Elements in the cache, should be CONSIDERED NON-EXISTANT. You should NOT count them in the final output.
In case there are NO dataSets in the data, you should NOT do anything.
Input
•	The input comes in the form of commands in one of the formats specified above.
•	The input ends when you receive the command “thetinggoesskrra”.
Output
•	As output you must print the dataSet with the HIGHEST SUM of all dataSizes.
•	The output format is:
Data Set: {dataSet}, Total Size: {sumOfAllDataSizes}
$.{dataKey1}
$.{dataKey2}
...
•	In case there are NO dataSets in the data, print nothing.
Constrains
•	The dataSet and dataKey are both strings which may contain ANY ASCII character except ‘ ’, ‘-’, ‘>’, ‘|’.
•	The dataSize is a valid integer in range [0, 1.000.000.000].
•	There will be NO invalid input lines.
•	There will be NO dataSets with EQUAL SUMMED dataSize.
•	There will be NO DUPLICATE keys.
•	Allowed working time/memory: 100ms / 16MB.

 */