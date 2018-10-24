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

public class PutridFartTest {

    private final String DEFAULT_NAME = "Boko";
    private final int DEFAULT_DAMAGE = 50;
    private final int DEFAULT_HEALTH = 70;
    private final int ZERO = 0;

    private Blob attacker;
    private Blob target;

    @Before
    public void init() {
        Attack attack = new PutridFart();
        Behavior behavior = new Aggressive();
        Subject subject = Mockito.mock(Subject.class);

        this.attacker = new Blob(DEFAULT_NAME, DEFAULT_HEALTH, DEFAULT_DAMAGE, behavior, attack, subject);
        this.target = new Blob(DEFAULT_NAME, DEFAULT_HEALTH, DEFAULT_DAMAGE, behavior, attack, subject);
    }

    @Test
    public void executeWhenAfterHitTargetStillAlive() {
        this.attacker.attack(this.target);

        int actual = this.target.getHealth();
        int expected = DEFAULT_HEALTH - this.attacker.getDamage();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void executeWhenAfterHitTargetDie() {
        this.attacker.attack(this.target);
        this.attacker.attack(this.target);

        int actual = this.target.getHealth();
        int expected = ZERO;

        Assert.assertEquals(expected, actual);
    }
}