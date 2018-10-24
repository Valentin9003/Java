package factory;

import entity.antiHeroDto.Titan;
import entity.antiHeroDto.Villain;
import entity.heroDto.DCHero;
import entity.heroDto.MarvelHero;
import entity.interfaces.ComicCharacter;

public final class HeroFactory {

    private HeroFactory() {
    }

    public static ComicCharacter createHero(String name, String type, int energy, double health, double intelligence, double heroism) {
        ComicCharacter hero = null;
        switch (type){
            case "DCHero":
                hero = new DCHero(name, energy, health, intelligence, heroism);
                break;
            case "MarvelHero":
                hero = new MarvelHero(name, energy, health, intelligence, heroism);
                break;
        }
        return hero;
    }

    public static ComicCharacter antiHero(String name, String type, int energy, double health, double intelligence, double evilness) {
        ComicCharacter hero = null;
        switch (type){
            case "Titan":
                hero = new Titan(name, energy, health, intelligence, evilness);
                break;
            case "Villain":
                hero = new Villain(name, energy, health, intelligence, evilness);
                break;
        }
        return hero;
    }
}
