package p08_pokemonTrainer.engine;

import p08_pokemonTrainer.models.Pokemon;
import p08_pokemonTrainer.models.Trainer;

import java.util.Comparator;
import java.util.Map;

public class CommandCenter {

    private static final String FIRE_ELEMENT = "Fire";
    private static final String WATER_ELEMENT = "Water";
    private static final String ELECTRICITY_ELEMENT = "Electricity";

    public CommandCenter() {
    }

    public void caughtPokemon(Map<String,Trainer> trainersDB, String tournamentLine) {
        /**input is in format “<TrainerName> <PokemonName> <PokemonElement> <PokemonHealth>”*/
        String[] tokens = tournamentLine.split("\\s+");

        String trainerName = tokens[0];
        String pokemonName = tokens[1];
        String pokemonElement = tokens[2];
        int pokemonHealth = Integer.parseInt(tokens[3]);

        Trainer trainer = new Trainer(trainerName);
        trainersDB.putIfAbsent(trainerName, trainer);

        Pokemon pokemon = new Pokemon(pokemonName, pokemonElement, pokemonHealth);
        trainersDB.get(trainerName).addPokemon(pokemon);
    }

    public void execute(Map<String,Trainer> trainersDB, String elementLine) {
        switch (elementLine) {
            case FIRE_ELEMENT:
                action(FIRE_ELEMENT, trainersDB);
                break;
            case WATER_ELEMENT:
                action(WATER_ELEMENT, trainersDB);
                break;
            case ELECTRICITY_ELEMENT:
                action(ELECTRICITY_ELEMENT, trainersDB);
                break;
        }
    }

    private void action(String element, Map<String,Trainer> trainersDB) {
        /**For every command you must check if a trainer has atleast 1 pokemon with the given element,
         * if he does he receives 1 badge, otherwise all his pokemon lose 10 health,
         * if a pokemon falls to 0 or less health he dies and must be deleted from the
         * trainer’s collection. */

        trainersDB.values().forEach(trainer -> {
            if (trainer.hasAtleastOnePokemon(element)) {
                trainer.receiveBadge();
            } else {
                trainer.decreasePokemonsHealth();
            }
        });
    }

    public void print(Map<String,Trainer> trainersDB) {
        /**print all trainers
         * sorted by the amount of badges they have in descending order
         * (if two trainers have the same amount of badges they should be sorted by
         * order of appearance in the input)*/

        trainersDB.values().stream()
                .sorted(Comparator.comparing(Trainer::getNumberOfBadges, Comparator.reverseOrder()))
                .forEach(System.out::println);
    }
}
