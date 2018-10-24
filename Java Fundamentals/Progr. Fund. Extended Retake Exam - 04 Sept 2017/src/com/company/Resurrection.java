package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.text.DecimalFormat;

public class Resurrection {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        DecimalFormat df = new DecimalFormat("###############################################0.#####################################################");

        int phoenixes = Integer.parseInt(reader.readLine());

        for (int i = 0; i < phoenixes; i++)
        {
            long totalBodyLength = Long.parseLong(reader.readLine());
            double totalBodyWidth = Double.parseDouble(reader.readLine());
            long wingLength = Long.parseLong(reader.readLine());

            BigDecimal totalYears = BigDecimal.valueOf(Math.pow(totalBodyLength, 2)).multiply((BigDecimal.valueOf(totalBodyWidth).add(BigDecimal.valueOf(wingLength * 2))));

//            double totalYears = Math.pow(totalBodyLength, 2) * (totalBodyWidth + 2 * wingLength);

            System.out.println(df.format(totalYears));
        }
    }
}

/*
You ever heard of Phoenixes? Magical Fire Birds that are practically immortal – they reincarnate from an egg when they die.
 Naturally, it takes time for them to reincarnate. You will play the role of a scientist who calculates the time to reincarnate
 for each phoenix, based on its body parameters.
You will receive N, an integer – the amount of phoenixes.
For each phoenix, you will receive 3 input lines:
•	On the first input line you will receive an integer – the total length of the body of the phoenix.
•	On the second input line you will receive a floating-point number – the total width of the body of the phoenix.
•	On the third input line you will receive an integer – the length of 1 wing of the phoenix.
For each phoenix, you must print the years it will take for it to reincarnate, which is calculated by the following formula:
The totalLength powered by 2, multiplied by the sum of the totalWidth and the totalWingLength (2 * wingLength).
totalYears = {totalLength} ^ 2 * ({totalWidth} + 2 * {wingLength})
Input
•	On the first input line you will receive N, an integer – the amount of phoenixes.
•	On the next N * 3 input lines you will be receiving data for each phoenix.
Output
•	As output, you must print the total years needed for reincarnation for each phoenix.
•	Print each phoenix’s years when you’ve calculated them.
•	Print each phoenix’s years on a new line.
Constrains
•	The amount of phoenixes will be an integer in range [0, 1000].
•	The total length of the body of the phoenix will be an integer in range [-231, 231].
•	The total width of the body of the phoenix will be a floating-point number in range [-231, 231].
•	The total width of the body of the phoenix will have up to 20 digits after the decimal point.
•	The total length of the wing of the phoenix will be an integer in range [-231, 231 – 1].
•	The total years is a product of integers and floating-point numbers, thus it is a floating-point number.
•	The total years should have the same accuracy as the total width.
•	Allowed working time / memory: 100ms / 16MB.

 */