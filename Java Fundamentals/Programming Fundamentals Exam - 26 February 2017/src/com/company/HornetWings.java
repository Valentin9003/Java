package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HornetWings {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        long wingsFlaps = Long.parseLong(reader.readLine());
        double distanceInMeters = Double.parseDouble(reader.readLine());
        int wingsFlapsBeforeBreak = Integer.parseInt(reader.readLine());

        double distance = (wingsFlaps / 1000) * distanceInMeters;
        long time = (wingsFlaps / 100) + ((wingsFlaps / wingsFlapsBeforeBreak) * 5);

        System.out.println(String.format("%.2f m.", distance));
        System.out.println(String.format("%d s.", time));
    }
}

/*
Problem 1 – Hornet Wings
The hornets are having a cardio contest. Your task is to calculate a contestant’s distance travelled, based upon the wing flaps he made.
However some hornet contestants are faster and less durable, while others are slower but have more endurance.
You will be given N – an integer indicating the wing flaps, a contestant has chosen to do.
After that, you will receive M – a floating-point number indicating the distance, in meters, the hornet travels for 1000 wing flaps.
Then you will receive P – an integer indicating the endurance of the contestant, or how many wing flaps he can make, before he stops to take a break and rest.
A hornet rests for 5 seconds.
You can assume that a hornet makes 100 wing flaps per second.
Your task is to calculate how much distance will the hornet travel, after it flaps its wings N times, and how much time it took him, to travel it.
The distance is measured in meters and the time – in seconds.
Input
•	On the first input line you will receive N – the wing flaps, the hornet has chosen to do.
•	On the second input line you will receive M – the distance the hornet travels for 1000 wing flaps.
•	On the third input line you will receive P – the endurance of the hornet.
Output
•	As output you must print the total distance the hornet contestant has travelled, and the amount of time it took him.
•	The output must be in the format of two lines:
-	On the first output line you must print the distance: “{metersTraveled} m.”
-	On the second output line you must print the time: “{secondsPassed} s.
•	The distance must be printed to the second digit after the decimal point.
Constrains
•	The integer N – the wing flaps, will be in range [0; 1,000,000,000].
•	The floating-point number M – the distance for 1000 wing flaps, will be in range [0; 1,000,000].
•	The integer P – the endurance, will be in range [1; N].
***************************************************************************************************************************************************
Input	|  Output
--------|----------
2000    | 10.00 m.
5       |    70 s.

Comments:
The contestant has chosen to do 2000 wing flaps.
He moves 5 meters per 1000 wing flaps.
He rests every 200 wing flaps for 5 seconds.
The distance is (2000 / 1000) * 5 = 2 * 5 = 10.00 meters.
The hornet flaps 100 times for a second, so 2000 / 100 = 20 seconds.
But it also rests for 5 seconds every 200 flaps.
(2000 / 200) * 5 = 10 * 5 = 50; 20 + 50 = 70 seconds.

 */