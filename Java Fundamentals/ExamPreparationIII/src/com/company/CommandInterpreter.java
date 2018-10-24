package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class CommandInterpreter {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] inputArr = reader.readLine().split("\\s+");
        String[] commands = reader.readLine().split(" ");

        while (!commands[0].equals("end"))
        {
            String command = commands[0];
            int startIndex = 0;
            int count = 0;

            switch (command) {
                case "reverse":
                    startIndex = Integer.parseInt(commands[2]);
                    count = Integer.parseInt(commands[4]);
                    if (startIndex < 0 || startIndex > inputArr.length - 1 || count < 0 || (count + startIndex - 1)  > inputArr.length - 1) {
                        System.out.println("Invalid input parameters.");
                        break;
                    }
                    ReverseArr(inputArr, startIndex, count);
                    break;
                case "sort":
                    startIndex = Integer.parseInt(commands[2]);
                    count = Integer.parseInt(commands[4]);
                    if (startIndex < 0 || startIndex > inputArr.length - 1 || count < 0 || (count + startIndex - 1) > inputArr.length - 1)
                    {
                        System.out.println("Invalid input parameters.");
                        break;
                    }
                    SortArray(inputArr, startIndex, count);
                    break;
                case "rollLeft":
                    count = Integer.parseInt(commands[1]);
                    if (count < 0)
                    {
                        System.out.println("Invalid input parameters.");
                        break;
                    }
                    RollLeftArray(inputArr, count);
                    break;
                case "rollRight":
                    count = Integer.parseInt(commands[1]);
                    if (count < 0)
                    {
                        System.out.println("Invalid input parameters.");
                        break;
                    }
                    RollRightArray(inputArr, count);
                    break;
            }
            commands = reader.readLine().split(" ");
        }

        PrintResult(inputArr);
    }

    private static void PrintResult(String[] inputArr)
    {
        ArrayList<String> resultList = new ArrayList<>();
        resultList.addAll(Arrays.asList(inputArr));
        System.out.println(resultList);
    }

    private static void RollRightArray(String[] inputArr, int count)
    {
        for (int i = 0; i < count % inputArr.length; i++) {
            String buff = inputArr[inputArr.length - 1];
            for (int j = inputArr.length - 1; j > 0; j--) {
                inputArr[j] = inputArr[j - 1];
            }
            inputArr[0] = buff;
        }
    }

    private static void RollLeftArray(String[] inputArr, int count)
    {
        for (int i = 0; i < count % inputArr.length; i++) {
            String buff = inputArr[0];
            for (int j = 0; j < inputArr.length - 1; j++) {
                inputArr[j] = inputArr[j + 1];
            }
            inputArr[inputArr.length - 1] = buff;
        }
    }

    private static void SortArray(String[] inputArr, int startIndex, int count)
    {
        int lastIndex = startIndex + count;
        Arrays.sort(inputArr, startIndex , lastIndex);
    }

    private static void ReverseArr(String[] inputArr, int startIndex, int count)
    {
        int elements = count / 2;
        int last = startIndex + count - 1;
        for (int i = startIndex; i <= startIndex + elements - 1 ; i++) {
            String buff = inputArr[i];
            inputArr[i] = inputArr[last];
            inputArr[last] = buff;
            last--;
        }

//        int left = startIndex;
//        int right = startIndex + count - 1;
//        while(left < right){
//            String temp = inputArr[left];
//            inputArr[left] = inputArr[right];
//            inputArr[right] = temp;
//            left++;
//            right--;
//        }
    }
}
