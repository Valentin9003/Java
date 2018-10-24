package models.attacks;

import interfaces.Attack;
import models.Blob;

public class PutridFart implements Attack {

    @Override
    public void execute(Blob attacker, Blob target) {
        int currentHealth = target.getHealth();
        currentHealth -= attacker.getDamage();
        target.setHealth(currentHealth);
    }
}
