package com.company;
// 100-100 in Judge
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Ladybugs {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int fieldSize = Integer.parseInt(reader.readLine());
        int[] indexesOfAllLadybugs = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] bugsArr = CreatBugsArray(fieldSize, indexesOfAllLadybugs);

        List<String> commandList = new ArrayList<>(Arrays.asList(reader.readLine().split(" ")));
        while (!commandList.get(0).equals("end"))
        {
            int index = Integer.parseInt(commandList.get(0));
            String flyTo = commandList.get(1);
            int flyLength = Integer.parseInt(commandList.get(2));

            if ((index >= 0) && ((index <= (bugsArr.length - 1)) && (bugsArr[index] == 1)))
            {
                LadyBugsFly(bugsArr, index, flyTo, flyLength);
            }

            commandList = new ArrayList<>(Arrays.asList(reader.readLine().split(" ")));
        }

        for (int i = 0; i < bugsArr.length; i++) {
            System.out.print(bugsArr[i] + " ");
        }
    }

    private static void LadyBugsFly(int[] bugsArr, int index, String flyTo, int flyLength)
    {
        switch (flyTo) {
            case "right":
                bugsArr[index] = 0;
                for (int i = index + flyLength; i < bugsArr.length; i += flyLength) {
                    if (bugsArr[i] == 0) {
                        bugsArr[i] = 1;
                        break;
                    }
                }
                break;
            case "left":
                bugsArr[index] = 0;
                for (int i = index - flyLength; i >= 0; i -= flyLength) {
                    if (bugsArr[i] == 0) {
                        bugsArr[i] = 1;
                        break;
                    }
                }
                break;
        }
    }

    private static int[] CreatBugsArray(int fieldSize, int[] indexesOfAllLadybugs)
    {
        int[] bugsArr = new int[fieldSize];
        for (int i = 0; i < indexesOfAllLadybugs.length; i++) {
            if (indexesOfAllLadybugs[i] >=0 && indexesOfAllLadybugs[i] <= bugsArr.length - 1) {
                bugsArr[indexesOfAllLadybugs[i]] = 1;
            }
        }
        return bugsArr;
    }
}
