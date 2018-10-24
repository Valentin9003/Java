package com.company;
// 100/100 Judge
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Icarus {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Long> numbersList = Arrays.stream(reader.readLine().split("\\s+")).map(Long::valueOf).collect(Collectors.toList());

        int indexPosition = Integer.parseInt(reader.readLine());
        int[] indexP = new int[2];
        indexP[0] = indexPosition;
        indexP[1] = 1;

        String command = reader.readLine();

        while (!"Supernova".equals(command))
        {
            String[] commandArr = command.split("\\s+");
            String direction = commandArr[0];
            int steps = Integer.parseInt(commandArr[1]);

            switch (direction) {
                case "left":
                    IcarusStepingLeft(numbersList, steps, indexP);
                    break;
                case "right":
                    IcarusStepingRight(numbersList, steps, indexP);
                    break;
            }

            command = reader.readLine();
        }

        for (Long num : numbersList) {
            System.out.print(num + " ");
        }

    }

    private static void IcarusStepingRight(List<Long> numbersList, int steps, int[] indexP)
    {
        int index = indexP[0];
        int damage = indexP[1];

        for (int i = 0; i < steps; i++)
        {
            index++;

            if (index > numbersList.size() - 1)
            {
                index = 0;
                damage++;
            }

            long value = numbersList.get(index) - damage;
            numbersList.set(index, value);
        }

        indexP[0] = index;
        indexP[1] = damage;
    }

    private static void IcarusStepingLeft(List<Long> numbersList, int steps, int[] indexP)
    {
        int index = indexP[0];
        int damage = indexP[1];

        for (int i = 0; i < steps; i++)
        {
            index--;

            if (index < 0)
            {
                index = numbersList.size() - 1;
                damage++;
            }

            long value = numbersList.get(index) - damage;
            numbersList.set(index, value);
        }

        indexP[0] = index;
        indexP[1] = damage;
    }
}

/*
Icarus is the majestic phoenix who has been alive from the beginning of creation. Icarus travels through different planes.
When Icarus travels through a plane, he damages Reality itself with his overwhelming, beyond godlike flames.
You will receive a sequence of integers – the plane. After that you will receive 1 integer – an index in that sequence,
which is Icarus’s starting position. Icarus’s INITIAL DAMAGE is 1.
You will then begin receiving commands in the following format: “{direction} {steps}”. The direction will be either “left” or “right”,
and the steps will be an integer. Depending on the direction, Icarus must step through the sequence of integers to the left or right.
 Each time he steps on a NEW position, he damages it. In other words, he SUBTRACTS his current damage from the integer at that position.
 Walking left and right has its conditions though:
•	If Icarus passes beyond the start of the sequence (index: -1) while going left, he must go at the end of the sequence (index: length – 1).
•	If Icarus passes beyond the end of the sequence (index: length - 1) while going right, he must go at the start of the sequence (index: 0).
If 1 of the 2 cases stated above happens, Icarus increments his damage by 1.
The input ends when you receive the command “Supernova”. When that happens you must print what is left of the sequence.
Input
•	On the first input line you will get the sequence of integers, separated by spaces.
•	On the second input line you will get Icarus’s starting position.
•	On the next several input lines you will get the commands.
Output
•	As output you must print a single line containing the remaining elements of the sequence, separated by spaces.
Constrains
•	The integers in the sequence will be in range [0, 1000].
•	The initial position of Icarus will always be valid and inside the sequence’s indexes.
•	The direction will always be either “left” or “right”.
•	The steps will be in range [0, 1000].
•	There will be NO invalid input lines.
•	Allowed working time / memory: 100ms / 16MB.

 */