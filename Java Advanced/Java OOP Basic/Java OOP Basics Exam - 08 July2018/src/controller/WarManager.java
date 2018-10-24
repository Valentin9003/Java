package controller;

import entity.heroDto.Hero;
import entity.interfaces.Arena;
import entity.interfaces.ComicCharacter;
import entity.interfaces.SuperPower;

import java.util.LinkedHashMap;
import java.util.Map;

public class WarManager implements Manager {

    private final int DEFAULT_WON_BATTLES = 0;

    private Map<String, ComicCharacter> heroDB;
    private Map<String, ComicCharacter> antiHeroDB;
    private Map<String, Arena> arenaDB;
    private Map<String, SuperPower> superPowerPool;
    private int heroesWonBattles;
    private int antiHeroesWonBattles;

    public WarManager() {
        this.heroDB = new LinkedHashMap<>();
        this.antiHeroDB = new LinkedHashMap<>();
        this.arenaDB = new LinkedHashMap<>();
        this.superPowerPool = new LinkedHashMap<>();
        this.heroesWonBattles = DEFAULT_WON_BATTLES;
        this.antiHeroesWonBattles = DEFAULT_WON_BATTLES;
    }

    @Override
    public String checkComicCharacter(String characterName) {
        ComicCharacter character = this.heroDB.get(characterName);
        if (character == null) {
            character = this.antiHeroDB.get(characterName);
        }

        if (character == null) {
            return String.format("Sorry, fans! %s doesn't exist in our comics!", characterName);
        }
        if (character.getHealth() <= 0) {
            return String.format("%s has fallen in battle!", characterName);
        }
        return character.toString();
    }

    @Override
    public String addHero(ComicCharacter hero) {
        if (this.heroDB.containsKey(hero.getName())) {
            this.heroDB.get(hero.getName())
                    .boostCharacter(
                            hero.getEnergy(),
                            hero.getHealth(),
                            hero.getIntelligence());

            return String.format("%s evolved!.", hero.getName());
        }
        this.heroDB.put(hero.getName(), hero);
        return String.format("%s is ready for battle!", hero.getName());
    }

    @Override
    public String addAntiHero(ComicCharacter antiHero) {
        if (this.antiHeroDB.containsKey(antiHero.getName())) {
            this.antiHeroDB.get(antiHero.getName())
                    .boostCharacter(
                            antiHero.getEnergy(),
                            antiHero.getHealth(),
                            antiHero.getIntelligence());

            return String.format("%s is getting stronger!", antiHero.getName());
        }
        this.antiHeroDB.put(antiHero.getName(), antiHero);
        return String.format("%s is ready for destruction!", antiHero.getName());
    }

    @Override
    public String addArena(Arena arena) {
        if (this.arenaDB.containsKey(arena.getArenaName())) {
            return "A battle is about to start there!";
        }
        this.arenaDB.put(arena.getArenaName(), arena);
        return String.format("%s is becoming a fighting ground!", arena.getArenaName());
    }

    @Override
    public String addHeroToArena(String arena, String hero) {
        ComicCharacter heroCharacter = this.heroDB.get(hero);
        //TODO - not sure if the hero can fight only in one area!!!! TO CHECK!!!
        if (this.arenaDB.get(arena).containsHero(heroCharacter)) {
            return String.format("%s is fighting!", hero);
        }
        if (heroCharacter.getHealth() <= 0) {
            return String.format("%s is dead!", hero);
        }
        if (this.arenaDB.get(arena).isArenaFull()) {
            return "Arena is full!";
        }

        this.arenaDB.get(arena).addHero(heroCharacter);
        return String.format("%s is fighting for your freedom in %s!", hero, arena);
    }

    @Override
    public String addAntiHeroToArena(String arena, String antiHero) {
        ComicCharacter antiHeroCharacter = this.antiHeroDB.get(antiHero);
        //TODO - not sure if the hero can fight only in one area!!!! TO CHECK!!!
        if (this.arenaDB.get(arena).containsAntiHero(antiHeroCharacter)) {
            return String.format("%s is fighting!", antiHero);
        }
        if (antiHeroCharacter.getHealth() <= 0) {
            return String.format("%s is dead!", antiHero);
        }
        if (this.arenaDB.get(arena).isArenaFull()) {
            return "Arena is full!";
        }

        this.arenaDB.get(arena).addAntiHero(antiHeroCharacter);
        return String.format("%s and his colleagues are trying to take over %s!", antiHero, arena);
    }

    @Override
    public String loadSuperPowerToPool(SuperPower superPower) {
        if (this.superPowerPool.containsKey(superPower.getName())) {
            return "This super power already exists!";
        }
        this.superPowerPool.put(superPower.getName(), superPower);
        return String.format("%s added to pool!", superPower.getName());
    }

    @Override
    public String assignSuperPowerToComicCharacter(String comicCharacter, String superPower) {
        ComicCharacter character = this.heroDB.get(comicCharacter);
        if (character == null) {
            character = this.antiHeroDB.get(comicCharacter);
        }

        if (character.containsThisSuperpower(superPower)) {
            return String.format("%s already assigned!", superPower);
        }

        character.addSuperPower(this.superPowerPool.get(superPower));
        this.superPowerPool.remove(superPower);
        return String.format("%s has a new super power!", comicCharacter);
    }

    @Override
    public String usePowers(String characterName) {
        ComicCharacter character = this.heroDB.get(characterName);
        if (character == null) {
            character = this.antiHeroDB.get(characterName);
        }
        return character.useSuperPowers();
    }

    @Override
    public String startBattle(String arena) {
        if (this.arenaDB.get(arena).isArenaEmpty()) {
            return "SAFE ZONE!";
        }

        if (this.arenaDB.get(arena).fightHeroes()) {
            //the heroes won
            this.heroesWonBattles++;
            this.arenaDB.remove(arena);
            return String.format("Heroes won the battle of %s!", arena);
        }
        //antiHeroes Won
        this.antiHeroesWonBattles++;
        this.arenaDB.remove(arena);
        return String.format("Anti Heroes won the battle of %s!", arena);
    }

    @Override
    public String endWar() {
        if (this.heroesWonBattles >= this.antiHeroesWonBattles) {
            int countOfAllBattles = this.heroesWonBattles + this.antiHeroesWonBattles;
            return String.format("After %d battles our FRIENDLY HEROES WON!", countOfAllBattles);
        }

        return "WE ARE DOOMED!";
    }
}
