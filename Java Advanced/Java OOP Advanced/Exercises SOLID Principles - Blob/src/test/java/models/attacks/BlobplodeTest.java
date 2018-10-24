package models.attacks;

import interfaces.Attack;
import interfaces.Behavior;
import models.Blob;
import models.behavors.Aggressive;
import observers.Subject;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;

public class BlobplodeTest {

    private final String DEFAULT_NAME = "Boko";
    private final int DEFAULT_DAMAGE = 20;
    private final int DEFAULT_HEALTH = 100;
    private final int ZERO = 0;

    private Blob attacker;
    private Blob target;

    @Before
    public void init() throws Exception {
        Attack attack = new Blobplode();
        Behavior behavior = new Aggressive();
        Subject subject = Mockito.mock(Subject.class);

        this.attacker = new Blob(DEFAULT_NAME, DEFAULT_HEALTH, DEFAULT_DAMAGE, behavior, attack, subject);
        this.target = new Blob(DEFAULT_NAME, DEFAULT_HEALTH, DEFAULT_DAMAGE, behavior, attack, subject);
    }

    @Test
    public void executeTestAttackerHealthAfterAttackWhenStillWithMoreThanOneHealth() {
        this.attacker.attack(this.target);

        int actual = this.attacker.getHealth();
        int expected = DEFAULT_HEALTH - (DEFAULT_HEALTH / 2);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void executeTestTargetHealthAfterAttack() {
        this.attacker.attack(this.target);

        int actual = this.target.getHealth();
        int expected = DEFAULT_HEALTH - (this.attacker.getDamage() * 2);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void executeTestTargetDie() {
        this.attacker.attack(this.target);
        this.attacker.attack(this.target);

        int actual = this.target.getHealth();
        int expected = ZERO;

        Assert.assertEquals(expected, actual);
    }
}