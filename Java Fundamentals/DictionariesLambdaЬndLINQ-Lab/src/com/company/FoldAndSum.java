package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FoldAndSum {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> numbers = Arrays.stream(reader.readLine().split("\\s+")).map(Integer::valueOf).collect(Collectors.toList());
        int k = numbers.size() / 4;

        int[] firstArr = numbers.stream().limit(k).mapToInt(Integer::valueOf).toArray();
        firstArr = ReverseArray(firstArr);

        int[] secondArr = numbers.stream().skip(3 * k).limit(k).mapToInt(Integer::valueOf).toArray();
        secondArr = ReverseArray(secondArr);

        int[] firstAndSeconddArr = new int[firstArr.length + secondArr.length];
        System.arraycopy(firstArr, 0 , firstAndSeconddArr , 0, firstArr.length);
        System.arraycopy(secondArr, 0, firstAndSeconddArr, firstArr.length, secondArr.length);

        int[] centerArr = numbers.stream().skip(k).limit(2 * k).mapToInt(Integer::valueOf).toArray();

        int[] resultArr = SumTwoArrays(firstAndSeconddArr, centerArr);

        for (int num : resultArr) {
            System.out.print(num + " ");
        }

    }

    private static int[] SumTwoArrays(int[] firstAndSeconddArr, int[] centerArr) {
        int[] resultArr = new int[centerArr.length];
        for (int i = 0; i < resultArr.length; i++) {
            resultArr[i] = firstAndSeconddArr[i] + centerArr[i];
        }
        return resultArr;
    }

    private static int[] ReverseArray(int[] firstArr) {
        int left = 0;
        int right = firstArr.length - 1;
        while(left < right){
            int temp = firstArr[left];
            firstArr[left] = firstArr[right];
            firstArr[right] = temp;
            left++;
            right--;
        }
        return firstArr;
    }
}
