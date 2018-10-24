package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class PokemonEvolution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, List<String>> pokemonLTI = new LinkedHashMap<>();

        String input = reader.readLine();
        while (!"wubbalubbadubdub".equals(input))
        {
            String[] inputArr = input.split(" -> ");
            if (inputArr.length == 3) {
                //Store every pokemon and his evolutions
                //If you receive an existent pokemonName, you should add the new evolution to it.
                UpdatePokemonMap(pokemonLTI, inputArr);
            }
            else if (inputArr.length == 1) {
                //If you have received a pokemonName and you are printing its evolutions, the order is – by order of input.
                CheckForPokemonAndPrintIfFound(pokemonLTI, inputArr[0]);
            }

            input = reader.readLine();
        }

        //The pokemons must be printed by order of input.
        // Each pokemon’s evolutions must be ordered by evolution index in descending order.
        PrintPokemonsEvolutions(pokemonLTI);

    }

    private static void PrintPokemonsEvolutions(Map<String, List<String>> pokemonLTI)
    {
        pokemonLTI.forEach((key, value) -> {
            System.out.println("# " + key);

            value.stream().sorted((first,second) -> {
                int firstNum = Integer.parseInt(first.split(" <-> ")[1]);
                int secondNum = Integer.parseInt(second.split(" <-> ")[1]);

                return Integer.compare(secondNum, firstNum);
            }).forEach(System.out::println);
        });
    }

    private static void CheckForPokemonAndPrintIfFound(Map<String, List<String>> pokemonLTI, String pokemonName)
    {
        if (pokemonLTI.containsKey(pokemonName))
        {
            System.out.println("# " + pokemonName);
            for (String evolutionTypeIndex : pokemonLTI.get(pokemonName)) {
                System.out.println(evolutionTypeIndex);
            }
        }
    }

    private static void UpdatePokemonMap(Map<String, List<String>> pokemonLTI, String[] inputArr)
    {
        String pokemonName = inputArr[0];
        String evolutionTypeIndex = inputArr[1] + " <-> " + inputArr[2];

        pokemonLTI.putIfAbsent(pokemonName, new LinkedList<>());
        pokemonLTI.get(pokemonName).add(evolutionTypeIndex);
    }
}

/*
You have been tasked to keep track of pokemons and their evolutions. A pokemon can evolve in several phases and types.
 When it evolves, the pokemon has an evolution index, which indicates how much it has evolved.
You will receive input lines in the following format:
{pokemonName} -> {evolutionType} -> {evolutionIndex}
The pokemonName and evolutionType will be strings. The evolutionIndex will be an integer. Your task is to store every pokemon and his evolutions.
If you receive an existent pokemonName, you should add the new evolution to it.
A single pokemon may have many evolutions with the same type and the same index.
In some rare cases you may receive the following input:
{pokemonName}
When you receive only a pokemonName, you must check if there is such a pokemon, and if there is,
 you must print all of its evolutions by order of input.
The input sequence ends when you receive the command “wubbalubbadubdub”.
Then you must print all pokemons and their evolutions. The pokemons must be printed by order of input.
Each pokemon’s evolutions must be ordered by evolution index in descending order.
Input
•	The input will come in the form of lines in the format specified above.
•	In some rare cases you may have only one element of the input – the pokemonName.
•	The input sequence ends when you receive the command “wubbalubbadubdub”.
Output
•	Pokemons and their evolutions must be printed in the following format:
“# {pokemoName}
 {evolution1Type} <-> {evolution1Index}
 {evolution2Type} <-> {evolution2Index}
 …”
•	If you have received a pokemonName and you are printing its evolutions, the order is – by order of input.
•	If you have received the ending command, and you are printing the pokemons’ evolutions, the order is – by evolutionIndex in descending order.
Constrains
•	The pokemonName and evolutionType are strings which may contain any ASCII character
(except ‘-’, ‘ ’, ‘>’).
•	The evolutionIndex will be an integer in range [0, 1.000.000.000].
•	There will be NO invalid input data.
•	Allowed time / memory: 100ms / 16 MB.

 */