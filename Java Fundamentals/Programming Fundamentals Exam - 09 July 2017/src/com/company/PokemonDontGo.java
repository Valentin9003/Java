package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PokemonDontGo {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> numbers = Arrays.stream(reader.readLine().split("\\s+")).map(Integer::valueOf).collect(Collectors.toList());

        int removedElement = 0;
        int sumOfRemovedElements = 0;
        while (numbers.size() > 0)
        {
            int index = Integer.parseInt(reader.readLine());

            if (index < 0)
            {
                removedElement = numbers.get(0);
                sumOfRemovedElements += removedElement;
                numbers.set(0, numbers.get(numbers.size() - 1));
            }
            else if (index > numbers.size() - 1) {
                removedElement = numbers.get(numbers.size() - 1);
                sumOfRemovedElements += removedElement;
                numbers.set((numbers.size() - 1), numbers.get(0));
            }
            else {
                removedElement = numbers.remove(index);
                sumOfRemovedElements += removedElement;
            }

            if (numbers.size() > 0) {
                for (int i = 0; i < numbers.size(); i++) {
                    if (numbers.get(i) <= removedElement) {
                        int newValue = numbers.get(i) + removedElement;
                        numbers.set(i, newValue);
                    } else {
                        int newValue = numbers.get(i) - removedElement;
                        numbers.set(i, newValue);
                    }
                }
            }
        }

        System.out.println(sumOfRemovedElements);
    }
}

/*
Ely likes to play Pokemon Go a lot. But Pokemon Go bankrupted … So the developers made Pokemon Don’t Go out of depression.
And so Ely now plays Pokemon Don’t Go. In Pokemon Don’t Go, when you walk to a certain pokemon, those closer to you,

naturally get further, and those further from you, get closer.
You will receive a sequence of integers, separated by spaces – the distances to the pokemons.
Then you will begin receiving integers, which will correspond to indexes in that sequence.
When you receive an index, you must remove the element at that index from the sequence (as if you’ve captured the pokemon).
•	You must INCREASE the value of all elements in the sequence which are LESS or EQUAL to the removed element, with the value of the removed element.
•	You must DECREASE the value of all elements in the sequence which are GREATER than the removed element, with the value of the removed element.
If the given index is LESS than 0, remove the first element of the sequence, and COPY the last element to its place.
If the given index is GREATER than the last index of the sequence, remove the last element from the sequence, and COPY the first element to its place.
The increasing and decreasing of elements should be done in these cases, also. The element, whose value you should use is the REMOVED element.
The program ends when the sequence has no elements (there are no pokemons left for Ely to catch).
Input
•	On the first line of input you will receive a sequence of integers, separated by spaces.
•	On the next several lines you will receive integers – the indexes.
Output
•	When the program ends, you must print on the console, the summed up value of all REMOVED elements.
Constrains
•	The input data will consist ONLY of valid integers in the range [-2.147.483.648, 2.147.483.647].

 */