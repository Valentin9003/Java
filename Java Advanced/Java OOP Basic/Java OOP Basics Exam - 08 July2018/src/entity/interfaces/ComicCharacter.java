package entity.interfaces;

public interface ComicCharacter {

    void takeDamage(double damage);

    String getName();

    void boostCharacter(int energy, double health, double intelligence);

    int getEnergy();

    double getHealth();

    double getIntelligence();

    double attack();

    double getSpecial();

    String useSuperPowers();

    void addSuperPower(SuperPower superPower);

    boolean containsThisSuperpower(String superPower);

}
