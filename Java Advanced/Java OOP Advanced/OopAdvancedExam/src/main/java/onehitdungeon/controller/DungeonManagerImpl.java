package onehitdungeon.controller;

import onehitdungeon.entity.heroes.PaladinHero;
import onehitdungeon.factories.HeroFactory;
import onehitdungeon.interfaces.DungeonManager;
import onehitdungeon.interfaces.Hero;
import onehitdungeon.interfaces.HeroTrainer;

import java.lang.reflect.Field;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static onehitdungeon.constants.Config.*;

public class DungeonManagerImpl implements DungeonManager {

    private long currentDungionLevel;
    private Hero selectedHero;
    private HeroTrainer heroTrainer;
    private Map<String, Hero> heroes;

    public DungeonManagerImpl(HeroTrainer heroTrainer) {
        this.currentDungionLevel = DUNGION_BASE_LEVEL;
        this.heroTrainer = heroTrainer;
        this.heroes = new LinkedHashMap<>();
    }

    @Override
    public String hero(List<String> arguments) {
        String type = arguments.get(1);
        String name = arguments.get(2);

        Hero hero = HeroFactory.create(type, name);

        if (this.heroes.size() == 0) {
            this.selectedHero = hero;
        }

        this.heroes.putIfAbsent(name, hero);

        return String.format("Successfully added %s - %s.", type, name);
    }

    @Override
    public String select(List<String> arguments) {
        String name = arguments.get(1);

        if (this.heroes.containsKey(name)) {
            this.selectedHero = this.heroes.get(name);
        }

        String type;
        if (this.selectedHero instanceof PaladinHero) {
            type = "Paladin";
        } else {
            type = "Mage";
        }

        return String.format("Successfully selected %s - %s.",
                type,
                this.selectedHero.getName());
    }

    @Override
    public String status(List<String> arguments) {
        return this.selectedHero.toString();
    }

    @Override
    public String fight(List<String> arguments) {
        long dungeonBP = calculateDungionBP();
        if (this.selectedHero.getTotalBattlePower() >= dungeonBP) {
            double dungionGold = calculateDungiomGold();

            this.selectedHero.earnGold(dungionGold);

            return String.format("Fight won. You've gained %.2f gold.", dungionGold);
        } else {
            this.currentDungionLevel--;
            if (this.currentDungionLevel < DUNGION_BASE_LEVEL) {
                this.currentDungionLevel = DUNGION_BASE_LEVEL;
            }
            return String.format("Fight lost. You've returned to the previous level.");
        }
    }

    private double calculateDungiomGold() {
        double gold = DUNGION_GOLD_REWARD;
        for (int i = 1; i < this.currentDungionLevel; i++) {
            gold *= 2;
        }

        return gold;
    }

    private long calculateDungionBP() {
        long bp = DUNGION_BASE_BP;
        for (int i = 1; i < this.currentDungionLevel; i++) {
            bp *= 2;
        }
        
        return bp;
    }

    @Override
    public String advance(List<String> arguments) {
        this.currentDungionLevel++;

        return String.format("Successfully advanced to dungeon level %d.", this.currentDungionLevel);
    }

    @Override
    public String train(List<String> arguments) {
        if (this.selectedHero.getGold() >= this.selectedHero.getTotalPriceForUpgrade()) {

            this.selectedHero.payGold(this.selectedHero.getTotalPriceForUpgrade());
            this.heroTrainer.trainHero(this.selectedHero);

            try {
                Field timesTrained = this.selectedHero.getClass().getDeclaredField("timesTrained");
                timesTrained.setAccessible(true);
                Integer value = (Integer) timesTrained.get(this.selectedHero);
                timesTrained.setInt(this.selectedHero, ++value);

            } catch (NoSuchFieldException | IllegalAccessException e) {
                e.printStackTrace();
            }

            return String.format("Successfully trained hero. Current total battle power: %d.",
                    this.selectedHero.getTotalBattlePower());
        }

        return String.format("Insufficient gold for training. Needed %.2f. Got %.2f.",
                this.selectedHero.getTotalPriceForUpgrade(),
                this.selectedHero.getGold());
    }

    @Override
    public String quit(List<String> arguments) {
        StringBuilder sb = new StringBuilder();

        this.heroes.values()
                .forEach(hero -> {
                    String type;
                    if (hero instanceof PaladinHero) {
                        type = "Paladin";
                    } else {
                        type = "Mage";
                    }

                    sb.append(String.format("%s %s - %d (BP)",
                            type, hero.getName(), hero.getTotalBattlePower()))
                    .append(System.lineSeparator());
                });

        sb.append("####################")
                .append(System.lineSeparator())
                .append(String.format("Dungeon level reached: %d", this.currentDungionLevel));


        return sb.toString().trim();
    }
}
