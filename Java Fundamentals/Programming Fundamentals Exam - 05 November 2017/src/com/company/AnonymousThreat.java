package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AnonymousThreat {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<String> myList = new ArrayList<>(Arrays.asList(reader.readLine().split("\\s+")));

        String input = reader.readLine();
        while (!"3:1".equals(input)) {
            String[] commArr = input.split("\\s+");
            String command = commArr[0];

            switch (command) {
                case "merge":
                    int startIndex = Integer.parseInt(commArr[1]);
                    int endIndex = Integer.parseInt(commArr[2]);

                    if (startIndex < 0) {
                        startIndex = 0;
                    } else if (startIndex > myList.size() - 1) {
                        break;
                    }
                    if (endIndex > myList.size() - 1) {
                        endIndex = myList.size() - 1;
                    }

                    ArrayList<String> buffList = new ArrayList<>();
                    for (int i = 0; i < startIndex; i++) {
                        buffList.add(myList.get(i));
                    }

                    StringBuilder sb = new StringBuilder();
                    for (int i = startIndex; i <= endIndex; i++) {
                        sb.append(myList.get(i));
                    }
                    buffList.add(sb.toString());

                    for (int i = endIndex + 1; i < myList.size(); i++) {
                        buffList.add(myList.get(i));
                    }
                    myList.clear();
                    myList.addAll(buffList);

                    break;
                case "divide":
                    int index = Integer.parseInt(commArr[1]);
                    int partitions = Integer.parseInt(commArr[2]);
                    if (index > myList.size() - 1) {
                        break;
                    }

                    if (myList.get(index).length() % partitions == 0 ) {

                        ArrayList<String> buff = new ArrayList<>();
                        for (int i = 0; i < index; i++) {
                            buff.add(myList.get(i));
                        }

                        int wordLength = myList.get(index).length();
                        int step = wordLength / partitions;
                        int indx = 0;
                        int endIdtx = step;
                        for (int i = 0; i < partitions; i++) {
                            String element = myList.get(index).substring(indx, endIdtx);
                            buff.add(element);
                            indx = endIdtx;
                            endIdtx += step;
                        }

                        for (int i = index + 1; i < myList.size(); i++) {
                            buff.add(myList.get(i));
                        }

                        myList.clear();
                        myList.addAll(buff);
                    }
                    else {
                        ArrayList<String> buff = new ArrayList<>();
                        for (int i = 0; i < index; i++) {
                            buff.add(myList.get(i));
                        }

                        int chCounts = myList.get(index).length() / partitions;
                        int str = 0;
                        int finishCh = 0;
                        if (chCounts > 0) {
                            str = 0;
                            finishCh = str + chCounts;

                            for (int i = 0; i < partitions; i++) {
                                if (i == partitions - 1) {
                                    String element = myList.get(index).substring(str, myList.get(index).length() - 1);
                                    buff.add(element);
                                } else {
                                    String element = myList.get(index).substring(str, finishCh);
                                    buff.add(element);
                                    str = finishCh;
                                    finishCh += chCounts;
                                }
                            }
                        }

                        for (int i = index + 1; i < myList.size(); i++) {
                            buff.add(myList.get(i));
                        }

                        myList.clear();
                        myList.addAll(buff);
                    }
                    break;
            }

            input = reader.readLine();
        }

        for (String str : myList) {
            System.out.print(str + " ");
        }
    }
}

/*
The Anonymous have created a cyber hypervirus which steals data from the CIA. You, as the lead security developer in CIA,
 have been tasked to analyze the software of the virus and observe its actions on the data. The virus is known for his
 innovative and unbeleivably clever technique of merging and dividing data into partitions.
You will receive a single input line containing STRINGS separated by spaces.
The strings may contain any ASCII character except whitespace.
You will then begin receiving commands in one of the following formats:
•	merge {startIndex} {endIndex}
•	divide {index} {partitions}
Every time you receive the merge command, you must merge all elements from the startIndex, till the endIndex. In other words, you should concatenate them.
Example: {abc, def, ghi} -> merge 0 1 -> {abcdef, ghi}
If any of the given indexes is out of the array, you must take ONLY the range that is INSIDE the array and merge it.
Every time you receive the divide command, you must DIVIDE the element at the given index, into several small substrings with equal length.
 The count of the substrings should be equal to the given partitions.
Example: {abcdef, ghi, jkl} -> divide 0 3 -> {ab, cd, ef, ghi, jkl}
If the string CANNOT be exactly divided into the given partitions, make all partitions except the LAST with EQUAL LENGTHS, and make the LAST one – the LONGEST.
Example: {abcd, efgh, ijkl} -> divide 0 3 -> {a, b, cd, efgh, ijkl}
The input ends when you receive the command “3:1”. At that point you must print the resulting elements, joined by a space.
Input
•	The first input line will contain the array of data.
•	On the next several input lines you will receive commands in the format specified above.
•	The input ends when you receive the command “3:1”.
Output
•	As output you must print a single line containing the elements of the array, joined by a space.
Constrains
•	The strings in the array may contain any ASCII character except whitespace.
•	The startIndex and the endIndex will be in range [-1000, 1000].
•	The endIndex will ALWAYS be GREATER than the startIndex.
•	The index in the divide command will ALWAYS be INSIDE the array.
•	The partitions will be in range [0, 100].
•	Allowed working time/memory: 100ms / 16MB.

 */