package p08_pokemonTrainer.engine;

import p08_pokemonTrainer.models.Trainer;

import java.util.LinkedHashMap;
import java.util.Map;

public class ProgramEngine {

    private CommandCenter commandCenter;
    /**trainerName are unique there cannot be 2 trainers with the same name
     * Map<trainerName, Trainer>*/
    private Map<String, Trainer> trainersDB;

    public ProgramEngine() {
        this.trainersDB = new LinkedHashMap<>();
        this.commandCenter = new CommandCenter();
    }


    public void caughtPokemon(String tournamentLine) {
        commandCenter.caughtPokemon(trainersDB, tournamentLine);
    }

    public void executeCommand(String elementLine) {
        this.commandCenter.execute(trainersDB, elementLine);
    }

    public void printResult() {
        this.commandCenter.print(trainersDB);
    }

}
