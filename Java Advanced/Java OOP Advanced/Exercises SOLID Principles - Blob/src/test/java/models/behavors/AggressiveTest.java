package models.behavors;

import interfaces.Attack;
import interfaces.Behavior;
import models.Blob;
import observers.Subject;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class AggressiveTest {

    private final String DEFAULT_NAME = "Boko";
    private final int DEFAULT_DAMAGE = 50;
    private final int DEFAULT_HEALTH = 20;
    private final int AGGRESSIVE_DAMAGE_DECREMENT = 5;

    private Behavior aggressive;
    private Blob blob;

    @Before
    public void initializer() {
        this.aggressive = new Aggressive();
        Attack attack = Mockito.mock(Attack.class);
        Subject subject = Mockito.mock(Subject.class);

        this.blob = new Blob(
                DEFAULT_NAME,
                DEFAULT_HEALTH,
                DEFAULT_DAMAGE,
                this.aggressive,
                attack,
                subject);
    }

    @Test
    public void trigger() {
        this.aggressive.trigger(this.blob);

        int actual = this.blob.getDamage();
        int expected = DEFAULT_DAMAGE * 2;

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void applyRecurrentEffectTestAfterEffectDamageStillBiggestThanInitialDamage() {
        this.aggressive.applyRecurrentEffect(this.blob);
        this.aggressive.applyRecurrentEffect(this.blob);

        int actual = this.blob.getDamage();
        int expected = DEFAULT_DAMAGE - AGGRESSIVE_DAMAGE_DECREMENT;

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void applyRecurrentEffectTestAfterEffectDamageIsLessThanInitialDamage() {
        this.aggressive.trigger(this.blob);

        this.blob.setDamage(20);

        this.aggressive.applyRecurrentEffect(this.blob);
        this.aggressive.applyRecurrentEffect(this.blob);

        int actual = this.blob.getDamage();
        int expected = DEFAULT_DAMAGE;

        Assert.assertEquals(expected, actual);
    }
}