package hell.core;

import hell.core.commands.InspectCommand;
import hell.factories.CommonItemFactory;
import hell.factories.HeroFactory;
import hell.factories.RecipeFactory;
import hell.interfaces.*;
import hell.interfaces.Runnable;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;

public class Engine implements Runnable {

    private static final String TERMINATE_COMMAND = "Quit";

    private InputReader reader;
    private OutputWriter writer;
    private Map<String, Hero> heroes;

    public Engine(InputReader reader, OutputWriter writer) {
        this.reader = reader;
        this.writer = writer;
        this.heroes = new LinkedHashMap<>();
    }

    @Override
    public void run() {
        String line;
        while (!TERMINATE_COMMAND.equalsIgnoreCase(line = this.reader.readLine())) {
            String[] data = line.split("\\s+");

            String commandName = data[0];
            String[] commandArgs = Arrays.stream(data).skip(1).toArray(String[]::new);

            switch (commandName) {
                case "Hero":
                    Hero hero = HeroFactory.execute(commandArgs);
                    if (hero != null) {
                        heroes.putIfAbsent(hero.getName(), hero);

                        this.writer.writeLine(String.format("Created %s - %s",
                                hero.getClass().getSimpleName(),
                                hero.getName()));
                    }
                    break;
                case "Item":
                    Item item = CommonItemFactory.execute(commandArgs);
                    String heroName = commandArgs[1];
                    if (this.heroes.containsKey(heroName)) {
                        this.heroes.get(heroName).addItem(item);

                        this.writer.writeLine(String.format("Added item - %s to Hero - %s",
                                item.getName(),
                                heroName));
                    }
                    break;
                case "Recipe":
                    Recipe recipe = RecipeFactory.execute(commandArgs);
                    if (this.heroes.containsKey(commandArgs[1])) {
                        this.heroes.get(commandArgs[1]).addRecipe(recipe);

                        this.writer.writeLine(String.format("Added recipe - %s to Hero - %s",
                                recipe.getName(),
                                commandArgs[1]));
                    }
                    break;
                case "Inspect":
                    if (this.heroes.containsKey(commandArgs[0])) {
                        String result = InspectCommand.inspect(this.heroes.get(commandArgs[0]));
                        this.writer.writeLine(result);
                    }
                    break;
            }
        }

        final int[] index = {1};
        this.heroes.values()
                .stream()
                .sorted(getHeroesComparator())
                .forEach(hero -> {
                    System.out.print(index[0]++ + ". ");
                    this.writer.writeLine(hero.toString());
                });

    }

    private Comparator<? super Hero> getHeroesComparator() {
        return (hero1, hero2) -> {
            long firstComparatorSumHero1 = hero1.getStrength() + hero1.getAgility() + hero1.getIntelligence();
            long firstComparatorSumHero2 = hero2.getStrength() + hero2.getAgility() + hero2.getIntelligence();

            int comparatorByFirstSum = Long.compare(firstComparatorSumHero2, firstComparatorSumHero1);

            if (comparatorByFirstSum != 0) {
                return comparatorByFirstSum;
            }

            long secondComparatorSumHero1 = hero1.getHitPoints() + hero1.getDamage();
            long secondComparatorSumHero2 = hero2.getHitPoints() + hero2.getDamage();

            return Long.compare(secondComparatorSumHero2, secondComparatorSumHero1);
        };
    }
}
