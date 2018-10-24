package p08_pokemonTrainer.models;

public class Pokemon {

    private static final int DEFAULT_HEALTH_LOSE = 10;

    private String name;
    private String element;
    private int health;

    public Pokemon(String name, String element, int health) {
        this.name = name;
        this.element = element;
        this.health = health;
    }

    public String getName() {
        return name;
    }

    public String getElement() {
        return element;
    }

    public int getHealth() {
        return health;
    }

    public void reduceHealth() {
        this.health -= DEFAULT_HEALTH_LOSE;
    }
}
