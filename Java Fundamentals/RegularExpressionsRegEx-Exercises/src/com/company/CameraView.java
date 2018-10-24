/*
You are an amateur photographer and you want to calculate what will be seen in your pictures.
On the first line, you will receive an array of integers with exactly two elements:
First element – m will be the elements, which you have to skip. The second element – n will be the elements, which
you have to take.
On the next line, you will receive a string, in which every camera will be marked with "|<". Skip the next m elements
immediately after the camera and take the next n elements.
If you encounter new camera in the view  stop the current camera and start new view with the newly found.
Output
Print all the taken views separated with ", ".
 */
package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CameraView {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String input = reader.readLine();
        int[] myArr = Arrays.stream(input.split(" ")).mapToInt(Integer::valueOf).toArray();
        ArrayList<String> myList = new ArrayList<>(Arrays.asList(reader.readLine().split("\\|")));

        String reGex = "^<([a-zA-Z1-9]{" + myArr[0] + "})?([A-Za-z1-9]{1," + myArr[1] + "})";
        Pattern pattern = Pattern.compile(reGex);

        List<String> resultList = new ArrayList<>();
        for (String s : myList) {
            Matcher matcher = pattern.matcher(s);

            if (matcher.find()) {
                resultList.add(matcher.group(2));
            }
        }

        System.out.println(String.join(", ", resultList));
    }
}

//9 7
//GreatBigSea|<uglyStuffHawaii|<boriiiingKilauea
//
//0 5
//|>invalid|<beach|noMoreCameras
