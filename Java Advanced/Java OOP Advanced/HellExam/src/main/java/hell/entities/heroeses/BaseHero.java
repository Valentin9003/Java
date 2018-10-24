package hell.entities.heroeses;

import hell.entities.miscellaneous.HeroInventory;
import hell.interfaces.Hero;
import hell.interfaces.Inventory;
import hell.interfaces.Item;
import hell.interfaces.Recipe;

import java.lang.reflect.Field;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public abstract class BaseHero implements Hero {

    private String name;
    private int strength;
    private int agility;
    private int intelligence;
    private int hitPoints;
    private int damage;
    private Inventory inventory;

    protected BaseHero(String name, int strength, int agility, int intelligence, int hitPoints, int damage, Inventory inventory) {
        this.name = name;
        this.strength = strength;
        this.agility = agility;
        this.intelligence = intelligence;
        this.hitPoints = hitPoints;
        this.damage = damage;
        this.inventory = inventory;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public long getStrength() {
        return this.strength + this.inventory.getTotalStrengthBonus();
    }

    @Override
    public long getAgility() {
        return this.agility + this.inventory.getTotalAgilityBonus();
    }

    @Override
    public long getIntelligence() {
        return this.intelligence + this.inventory.getTotalIntelligenceBonus();
    }

    @Override
    public long getHitPoints() {
        return this.hitPoints + this.inventory.getTotalHitPointsBonus();
    }

    @Override
    public long getDamage() {
        return this.damage + this.inventory.getTotalDamageBonus();
    }

    @Override
    @SuppressWarnings("unchecked")
    public Collection<Item> getItems() {
        Collection<Item> items = null;
        try {
            Field commonItemsField = this.inventory.getClass().getDeclaredField("commonItems");
            commonItemsField.setAccessible(true);
            Map<String, Item> commonItems = (Map<String, Item>) commonItemsField.get(this.inventory);
            items = commonItems.values();
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }

        return items;
    }

    @Override
    public void addItem(Item item) {
        this.inventory.addCommonItem(item);
    }

    @Override
    public void addRecipe(Recipe recipe) {
        this.inventory.addRecipeItem(recipe);
    }

    @Override
    public String toString() {
        StringBuilder heroBuilder = new StringBuilder();
        heroBuilder.append(String.format("%s: %s", this.getClass().getSimpleName(), this.getName()))
                .append(System.lineSeparator())
                .append(String.format("###HitPoints: %d", this.getHitPoints()))
                .append(System.lineSeparator())
                .append(String.format("###Damage: %d", this.getDamage()))
                .append(System.lineSeparator())
                .append(String.format("###Strength: %d", this.getStrength()))
                .append(System.lineSeparator())
                .append(String.format("###Agility: %d", this.getAgility()))
                .append(System.lineSeparator())
                .append(String.format("###Intelligence: %d", this.getIntelligence()))
                .append(System.lineSeparator())
                .append("###Items: ");

        String items = this.getItems().size() == 0 ?
                "None" :
                this.getItems().stream()
                        .map(Item::getName)
                        .collect(Collectors.joining(", "));

        heroBuilder.append(items);

        return heroBuilder.toString();
    }
}
