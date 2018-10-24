package hell.core.commands;

import hell.interfaces.Hero;
import hell.interfaces.Item;

import java.util.stream.Collectors;

public final class InspectCommand {

    private InspectCommand() {
    }

    public static String inspect(Hero hero) {
        StringBuilder heroBuilder = new StringBuilder();
        heroBuilder.append(String.format("Hero: %s, Class: %s", hero.getName(), hero.getClass().getSimpleName()))
                .append(System.lineSeparator())
                .append(String.format("HitPoints: %d, Damage: %d", hero.getHitPoints(), hero.getDamage()))
                .append(System.lineSeparator())
                .append(String.format("Strength: %d", hero.getStrength()))
                .append(System.lineSeparator())
                .append(String.format("Agility: %d", hero.getAgility()))
                .append(System.lineSeparator())
                .append(String.format("Intelligence: %d", hero.getIntelligence()))
                .append(System.lineSeparator());

        String items = hero.getItems().size() == 0 ?
                "None" :
                hero.getItems().stream()
                        .map(Item::toString)
                        .collect(Collectors.joining(""));

        heroBuilder.append("Items: " + items);

        return heroBuilder.toString();
    }
}
