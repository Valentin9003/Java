package rpg_lab_part2.interfaces;

import java.util.List;

public interface Target {

    List<Weapon> getPossibleLoot();

    int getHealth();

    void takeAttack(int attackPoints);

    int giveExperience();

    boolean isDead();
}
