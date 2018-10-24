package rpg_lab_part2.interfaces;

import rpg_lab_part2.Dummy;

public interface Weapon {

    int getAttackPoints();

    int getDurabilityPoints();

    void attack(Target target);
}
