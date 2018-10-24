package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Largest3Numbers {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> myList = Arrays.stream(reader.readLine().split("\\s+")).map(Integer::valueOf).collect(Collectors.toList());

        Collections.sort(myList);
        Collections.reverse(myList);

//        List<Integer> resultList = myList.stream().limit(3).collect(Collectors.toList());
//        System.out.println(resultList);

        System.out.println(myList.stream().limit(3).collect(Collectors.toList()));
    }
}
