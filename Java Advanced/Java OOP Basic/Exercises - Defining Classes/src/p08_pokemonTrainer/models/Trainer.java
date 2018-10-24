package p08_pokemonTrainer.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Trainer {

    private static final int DEFAULT_BADGES = 0;
    
    private String name;
    private int numberOfBadges;
    private List<Pokemon> pokemons;

    public Trainer(String name) {
        this.name = name;
        this.numberOfBadges = DEFAULT_BADGES;
        this.pokemons = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getNumberOfBadges() {
        return numberOfBadges;
    }

    public void receiveBadge() {
        this.numberOfBadges++;
    }

    public List<Pokemon> getPokemons() {
        return Collections.unmodifiableList(this.pokemons);
    }

    public void addPokemon(Pokemon pokemon) {
        this.pokemons.add(pokemon);
    }

    private void setPokemons(List<Pokemon> pokemons) {
        this.pokemons = pokemons;
    }

    public void deleteDeathPokemons() {
        List<Pokemon> newCollection =
                this.pokemons.stream()
                        .filter(pokemon -> pokemon.getHealth() > 0)
                        .collect(Collectors.toList());

       this.setPokemons(newCollection);
    }

    public void decreasePokemonsHealth() {
        this.pokemons.forEach(Pokemon::reduceHealth);
        this.deleteDeathPokemons();
    }

    public boolean hasAtleastOnePokemon (String element) {
        return this.pokemons.stream()
                .filter(pokemon -> pokemon.getElement().equals(element))
                .collect(Collectors.toList())
                .size() > 0;
    }

    @Override
    public String toString() {
        //“<TrainerName> <Badges> <NumberOfPokemon>”
        return String.format("%s %d %d", this.name, this.numberOfBadges, this.pokemons.size());
    }
}
