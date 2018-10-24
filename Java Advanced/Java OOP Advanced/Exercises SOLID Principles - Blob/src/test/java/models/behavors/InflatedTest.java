package models.behavors;

import interfaces.Attack;
import interfaces.Behavior;
import models.Blob;
import observers.Subject;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;

public class InflatedTest {

    private final String DEFAULT_NAME = "Boko";
    private final int DEFAULT_DAMAGE = 50;
    private final int DEFAULT_HEALTH = 100;
    private static final int INFLATED_HEALTH_INCREMENT = 50;
    private static final int INFLATED_HEALTH_DECREMENT = 10;

    private Behavior inflated;
    private Blob blob;

    @Before
    public void init() {
        this.inflated = new Inflated();
        Attack attack = Mockito.mock(Attack.class);
        Subject subject = Mockito.mock(Subject.class);

        this.blob = new Blob(
                DEFAULT_NAME,
                DEFAULT_HEALTH,
                DEFAULT_DAMAGE,
                this.inflated,
                attack,
                subject);
    }

    @Test
    public void trigger() {
        this.inflated.trigger(this.blob);

        int actual = this.blob.getHealth();
        int expected = DEFAULT_HEALTH + INFLATED_HEALTH_INCREMENT;

        Assert.assertEquals(expected, actual);
    }

    @Test(expected = IllegalStateException.class)
    public void triggerWhenIsAlreadyTriggered() {
        this.inflated.trigger(this.blob);
        this.inflated.trigger(this.blob);
    }

    @Test
    public void applyRecurrentEffect() {
        this.inflated.applyRecurrentEffect(this.blob);
        this.inflated.applyRecurrentEffect(this.blob);

        int actual = this.blob.getHealth();
        int expected = DEFAULT_HEALTH - INFLATED_HEALTH_DECREMENT;

        Assert.assertEquals(expected, actual);
    }
}