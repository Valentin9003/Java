package entity.interfaces;

public interface Arena {

    String getArenaName();

    boolean isArenaFull();

    void addHero(ComicCharacter hero);

    void addAntiHero(ComicCharacter antiHero);

    boolean fightHeroes();

    boolean containsHero(ComicCharacter heroCharacter);

    boolean containsAntiHero(ComicCharacter antiHeroCharacter);

    boolean isArenaEmpty();
}
