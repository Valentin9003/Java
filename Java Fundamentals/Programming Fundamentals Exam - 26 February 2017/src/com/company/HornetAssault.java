package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class HornetAssault {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Long> beehives = Arrays.stream(reader.readLine().split("\\s")).map(Long::valueOf).collect(Collectors.toList());
        List<Long> hornets = Arrays.stream(reader.readLine().split("\\s")).map(Long::valueOf).collect(Collectors.toList());

        List<Long> resultList = new ArrayList<>();

        for (Long beehive : beehives) {
            long hornetPower = hornets.stream().mapToLong(Long::longValue).sum();

            //If all hornets r death
            if (hornets.size() == 0) {
                resultList.add(beehive);
                continue;
            }
            if (beehive >= hornetPower)
            {
                if (beehive > hornetPower) {
                    resultList.add((beehive - hornetPower));
                }
                hornets.remove(0);
            }
        }

        //Print result - alive bees or if all bees r death will print alive hornets
        if (resultList.size() == 0) {
            for (Long hornet : hornets) {
                System.out.print(hornet + " ");
            }
        } else {
            for (Long beehive : resultList) {
                System.out.print(beehive + " ");
            }
        }
    }
}

/*
The hornets are preparing an assault on beehives. It takes very little amount of hornets to annihilate a beehive, but the bees are far from defenseless.
You must calculate how many beehives, can the hornets annihilate, before they die.
You will be given a sequence of integers, separated by a space. The integers will represent the beehives and the amount of bees in them.
You will then receive another sequence of integers, which will represent the hornets, and their power. The power indicates how many bees a hornet can kill.
The hornets must start attacking the beehives one by one. If the bees are more or equal to the summed-up power of the hornets, the first (entered) hornet, currently alive,
dies in the assault of the current beehive.
When the hornets assault a beehive, they kill an amount of bees, equal to their summed-up power. This means that you must decrease the integer of the beehive,
with the value of the summed-up power, of the live hornets.
After you’ve successfully assaulted all beehives, you must print the result of the winning side. If there are ANY beehives with live bees inside them,
you must print them. If there aren’t, you must print the live hornets.
Input
•	On the first line of input you will receive a sequence of integers, separated by spaces – the beehives.
•	On the second line of input you will receive a sequence of integers, separated by spaces – the hornets.
Output
•	Depending on the case of printing you must either print the live beehives, or the live hornets.
•	They are sequences of integers, so in both cases you must print them separated by a space.
Constrains
•	The input will consist only of integers in range [0; 1,000,000].
•	There will be NO STALEMATE situations.
•	The input sequences may consist of up to 3000 elements.

 */