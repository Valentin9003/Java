package p08_pokemonTrainer;

import p08_pokemonTrainer.engine.ProgramEngine;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static final String STOP_TOURNAMENT = "Tournament";
    private static final String END_PROGRAM = "End";

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        ProgramEngine engine = new ProgramEngine();

        String tournamentLine;
        while (!STOP_TOURNAMENT.equalsIgnoreCase(tournamentLine = reader.readLine())) {
            /**carry information about a pokemon and the trainer who caught it*/
            engine.caughtPokemon(tournamentLine);
        }

        String elementLine;
        while (!END_PROGRAM.equalsIgnoreCase(elementLine = reader.readLine())) {
            /**On every line you will receive elements, and you need to execute the command for given element*/
            engine.executeCommand(elementLine);
        }

        /**After the command “End” is received you should print result*/
        engine.printResult();
    }
}
