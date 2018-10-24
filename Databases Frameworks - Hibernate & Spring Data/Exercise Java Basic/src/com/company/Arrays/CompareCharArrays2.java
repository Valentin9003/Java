package com.company.Arrays;

import javafx.collections.transformation.SortedList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CompareCharArrays2 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String firstLine = reader.readLine().replaceAll(" ", "");
        String secondLine = reader.readLine().replaceAll(" ", "");

        List<String> justTestList = new ArrayList<>();
        justTestList.add(firstLine);
        justTestList.add(secondLine);

        Collections.sort(justTestList);
        for (String str : justTestList) {
            System.out.println(str);
        }
    }
}
