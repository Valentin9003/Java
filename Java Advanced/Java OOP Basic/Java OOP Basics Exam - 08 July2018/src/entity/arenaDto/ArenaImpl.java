package entity.arenaDto;

import entity.interfaces.Arena;
import entity.interfaces.ComicCharacter;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class ArenaImpl implements Arena {

    private String arenaName;
    private List<ComicCharacter> heroes;
    private List<ComicCharacter> antiHeroes;
    private int capacity;

    public ArenaImpl() {
    }

    public ArenaImpl(String arenaName, int capacity) {
        this.arenaName = arenaName;
        this.heroes = new LinkedList<>();
        this.antiHeroes = new LinkedList<>();
        this.capacity = capacity;
    }

    public String getArenaName() {
        return this.arenaName;
    }

    public List<ComicCharacter> getHeroes() {
        return Collections.unmodifiableList(this.heroes);
    }

    public List<ComicCharacter> getAntiHeroes() {
        return Collections.unmodifiableList(this.antiHeroes);
    }

    public int getCapacity() {
        return this.capacity;
    }

    @Override
    public boolean isArenaFull() {
        return (this.getHeroes().size() + this.getAntiHeroes().size()) == this.getCapacity();
    }

    @Override
    public void addHero(ComicCharacter hero) {
        this.heroes.add(hero);
    }

    @Override
    public void addAntiHero(ComicCharacter antiHero) {
        this.antiHeroes.add(antiHero);
    }

    @Override
    public boolean fightHeroes() {
        boolean isHeroesWon = false;
        boolean isAntiHeroesFirst = false;

        if (this.getHeroes().size() >= this.getAntiHeroes().size()) {
            isAntiHeroesFirst = true;
        }

        while (true) {
            if (isAntiHeroesFirst) {
                fight(this.antiHeroes, this.heroes);
            } else {
                fight(this.heroes, this.antiHeroes);
            }

            this.antiHeroes = removeDeathHeroes(this.antiHeroes);
            this.heroes = removeDeathHeroes(this.heroes);

            if (this.getAntiHeroes().size() == 0) {
                isHeroesWon = true;
                break;
            } else if (this.getHeroes().size() == 0) {
                break;
            }

            isAntiHeroesFirst = !isAntiHeroesFirst;
        }

        return isHeroesWon;
    }

    private List<ComicCharacter> removeDeathHeroes(List<ComicCharacter> list) {
       return list.stream()
               .filter(cc -> cc.getHealth() > 0 )
               .collect(Collectors.toList());
    }

    private void fight(List<ComicCharacter> firstCharacters, List<ComicCharacter> secondCharacters) {
        for (int i = 0; i < firstCharacters.size(); i++) {
            if (i >= secondCharacters.size()) {
                break;
            }
            secondCharacters.get(i).takeDamage(firstCharacters.get(i).attack());
        }
    }

    @Override
    public boolean containsHero(ComicCharacter heroCharacter) {
        return this.getHeroes().contains(heroCharacter);
    }

    @Override
    public boolean containsAntiHero(ComicCharacter antiHeroCharacter) {
        return this.getAntiHeroes().contains(antiHeroCharacter);
    }

    @Override
    public boolean isArenaEmpty() {
        return (this.getHeroes().size() + this.getAntiHeroes().size()) == 0;
    }
}
