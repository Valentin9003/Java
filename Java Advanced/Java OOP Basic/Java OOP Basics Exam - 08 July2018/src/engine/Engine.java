package engine;

import controller.Manager;
import controller.WarManager;
import entity.interfaces.Arena;
import entity.interfaces.ComicCharacter;
import entity.interfaces.SuperPower;
import factory.ArenaFactory;
import factory.HeroFactory;
import factory.PowerFactory;
import io.impl.ConsoleReaderImpl;
import io.impl.ConsoleWriterImpl;
import io.interfaces.Reader;
import io.interfaces.Writer;
import until.Config;

public class Engine {

    private Reader reader;
    private Writer writer;
    private Manager warManager;

    public Engine() {
        this.reader = new ConsoleReaderImpl();
        this.writer = new ConsoleWriterImpl();
        this.warManager = new WarManager();
    }

    public void run() {

        String line;
        while (!"WAR_IS_OVER".equalsIgnoreCase(line = this.reader.readLine())) {
            String[] tokens = line.split("\\s+");

            String command = tokens[0];
            switch (command){
                case Config.CHECK_CHARACTER:
                    executeCheck(tokens);
                    break;
                case Config.REGISTER_HERO:
                    executeRegisterHero(tokens);
                    break;
                case Config.REGISTER_ANTI_HERO:
                    executeRegisterAntiHero(tokens);
                    break;
                case Config.BUILD_ARENA:
                    executeBuildArena(tokens);
                    break;
                case Config.SEND_HERO:
                    executeAddHeroToArena(tokens);
                    break;
                case Config.SEND_ANTI_HERO:
                    executeAddAntiHeroToArena(tokens);
                    break;
                case Config.SUPER_POWER:
                    executeLoadSuperPowerToPool(tokens);
                    break;
                case Config.ASSIGN_POWER:
                    executeassingSuperPowerToComicCharacter(tokens);
                    break;
                case Config.UNLEASH:
                    executeUsePowers(tokens[1]);
                    break;
                case Config.COMICS_WAR:
                    executeStartBattle(tokens[1]);
                    break;
            }
        }

        /** When you get command "WAR_IS_OVER" the war stops .
         * If the HEROES has equal or more battles won they are
         * the winners. ELSE the ANTI HEROES WIN. The program ends! */
        String result = this.warManager.endWar();
        this.writer.writeLine(result);
    }

    private void executeStartBattle(String areaName) {
        //COMICS_WAR <arena name>
        String result = this.warManager.startBattle(areaName);
        this.writer.writeLine(result);
    }

    private void executeUsePowers(String comicCharacterName) {
        //UNLEASH <comic character name>
        String result = this.warManager.usePowers(comicCharacterName);
        this.writer.writeLine(result);
    }

    private void executeassingSuperPowerToComicCharacter(String[] tokens) {
        //ASSIGN_POWER <comic character name> <super power name>
        String characterName = tokens[1];
        String superPowerName = tokens[2];
        String result = this.warManager.assignSuperPowerToComicCharacter(characterName, superPowerName);
        this.writer.writeLine(result);
    }

    private void executeLoadSuperPowerToPool(String[] tokens) {
        //SUPER_POWER <super power name> <power points>
        String superPowerName = tokens[1];
        double powerPoints = Double.parseDouble(tokens[2]);
        try {
            SuperPower superPower = PowerFactory.createPower(superPowerName, powerPoints);
            String result = this.warManager.loadSuperPowerToPool(superPower);
            this.writer.writeLine(result);
        } catch (IllegalArgumentException iae) {
            this.writer.writeLine(iae.getMessage());
        }
    }

    private void executeAddAntiHeroToArena(String[] tokens) {
        //SEND_ANTI_HERO <arena name> <anti hero name>
        String arenaName = tokens[1];
        String antiHeroName = tokens[2];
        String result = this.warManager.addAntiHeroToArena(arenaName, antiHeroName);
        this.writer.writeLine(result);
    }

    private void executeAddHeroToArena(String[] tokens) {
        //SEND_HERO <arena name> <hero name>
        String arenaName = tokens[1];
        String heroName = tokens[2];
        String result = this.warManager.addHeroToArena(arenaName, heroName);
        this.writer.writeLine(result);
    }

    private void executeBuildArena(String[] tokens) {
        //BUILD_ARENA <arena name> <capacity>
        String areaName = tokens[1];
        int capacity = Integer.parseInt(tokens[2]);
        Arena arena = ArenaFactory.createArena(areaName, capacity);
        String result = this.warManager.addArena(arena);
        this.writer.writeLine(result);
    }

    private void executeRegisterAntiHero(String[] tokens) {
        //REGISTER_ANTI_HERO <character name> <type> <energy> <health> <intelligence> <evilness>
        String characterName = tokens[1];
        String type = tokens[2];
        int energy = Integer.parseInt(tokens[3]);
        double health = Double.parseDouble(tokens[4]);
        double intelligence = Double.parseDouble(tokens[5]);
        double evilness = Double.parseDouble(tokens[6]);

        try {
            ComicCharacter antiHero = HeroFactory.antiHero(characterName, type, energy, health, intelligence, evilness);
            String result = this.warManager.addAntiHero(antiHero);
            this.writer.writeLine(result);

        } catch (IllegalArgumentException iae) {
            this.writer.writeLine(iae.getMessage());
        }
    }

    private void executeRegisterHero(String[] tokens) {
        //REGISTER_HERO <character name> <type> <energy> <health> <intelligence> <heroism>
        String characterName = tokens[1];
        String type = tokens[2];
        int energy = Integer.parseInt(tokens[3]);
        double health = Double.parseDouble(tokens[4]);
        double intelligence = Double.parseDouble(tokens[5]);
        double heroism = Double.parseDouble(tokens[6]);

        try {
            ComicCharacter hero = HeroFactory.createHero(characterName, type, energy, health, intelligence, heroism);
            String result = this.warManager.addHero(hero);
            this.writer.writeLine(result);

        } catch (IllegalArgumentException iae) {
            this.writer.writeLine(iae.getMessage());
        }
    }

    private void executeCheck(String[] tokens) {
        //CHECK_CHARACTER <character name>
        String characterName = tokens[1];
        String result = this.warManager.checkComicCharacter(characterName);
        this.writer.writeLine(result);
    }
}
