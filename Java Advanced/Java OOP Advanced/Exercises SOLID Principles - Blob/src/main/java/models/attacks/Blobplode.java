package models.attacks;

import interfaces.Attack;
import models.Blob;

public class Blobplode implements Attack {

    private final int DEFAULT_ATTACK_INDEX = 2;

    @Override
    public void execute(Blob attacker, Blob target) {
        int attackerHealthAfterAttack = attacker.getHealth() - (attacker.getHealth() / 2);
        if (attackerHealthAfterAttack >= 1) {
            attacker.setHealth(attackerHealthAfterAttack);
        }
        target.setHealth(target.getHealth() - (attacker.getDamage() * DEFAULT_ATTACK_INDEX));
    }
}
