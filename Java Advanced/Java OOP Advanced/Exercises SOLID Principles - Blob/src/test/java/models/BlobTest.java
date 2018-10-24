package models;

import interfaces.Attack;
import interfaces.Behavior;
import models.attacks.Blobplode;
import models.behavors.Aggressive;
import observers.Subject;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;

public class BlobTest {

    private final String DEFAULT_FAILED_TEST_MSG = "Test failed! Wrong: ";
    private final String DEFAULT_NAME = "Boko";
    private final int DEFAULT_DAMAGE = 50;
    private final int DEFAULT_HEALTH = 20;
    private final int ZERO = 0;

    private Blob blob;
    private Behavior behavior;
    private Attack attack;

    @Before
    public void init() throws Exception {
        this.attack = new Blobplode();
        this.behavior = new Aggressive();
        Subject subject = Mockito.mock(Subject.class);

        this.blob = new Blob(DEFAULT_NAME, DEFAULT_HEALTH, DEFAULT_DAMAGE, behavior, attack, subject);
    }

    @Test
    public void getHealthTest() {
        int actual = this.blob.getHealth();
        int expected = DEFAULT_HEALTH;

        Assert.assertEquals(DEFAULT_FAILED_TEST_MSG, expected, actual);
    }

    @Test(expected = IllegalStateException.class)
    public void constructorTestWithNullBehavior() {
        Subject mockSubject = Mockito.mock(Subject.class);
        Blob blob = new Blob(DEFAULT_NAME, DEFAULT_HEALTH, DEFAULT_DAMAGE, null, this.attack, mockSubject);
    }

    @Test(expected = IllegalStateException.class)
    public void constructorTestWithNullAttack() {
        Subject mockSubject = Mockito.mock(Subject.class);
        Blob blob = new Blob(DEFAULT_NAME, DEFAULT_HEALTH, DEFAULT_DAMAGE, this.behavior, null, mockSubject);
    }

    @Test(expected = IllegalStateException.class)
    public void constructorTestWithNullAttackAndBehavior() {
        Subject mockSubject = Mockito.mock(Subject.class);
        Blob blob = new Blob(DEFAULT_NAME, DEFAULT_HEALTH, DEFAULT_DAMAGE, null, null, mockSubject);
    }

    @Test
    public void setHealthTest() {
        this.blob.setHealth(DEFAULT_HEALTH * 2);

        int actual = this.blob.getHealth();
        int expected = DEFAULT_HEALTH * 2;

        Assert.assertEquals(DEFAULT_FAILED_TEST_MSG, expected, actual);
    }

    @Test
    public void setHealthOnBlobWithNegativeHealth() {
        this.blob.setHealth(-50);

        int actual = this.blob.getHealth();
        int expected = ZERO;

        Assert.assertEquals(DEFAULT_FAILED_TEST_MSG, expected, actual);
    }

    @Test
    public void getDamageTest() {
        int actual = this.blob.getDamage();
        int expected = DEFAULT_DAMAGE;

        Assert.assertEquals(DEFAULT_FAILED_TEST_MSG, expected, actual);
    }

    @Test
    public void setDamageTest() {
        this.blob.setDamage(DEFAULT_DAMAGE * 2);

        int actual = this.blob.getDamage();
        int expected = DEFAULT_DAMAGE * 2;

        Assert.assertEquals(DEFAULT_FAILED_TEST_MSG, expected, actual);
    }

    @Test
    public void getBehaviorTest() {
        Assert.assertEquals(DEFAULT_FAILED_TEST_MSG, this.behavior, this.blob.getBehavior());
    }

    @Test
    public void getNameTest() {
        String actual = this.blob.getName();
        String expected = DEFAULT_NAME;

        Assert.assertEquals(DEFAULT_FAILED_TEST_MSG, expected, actual);
    }

    @Test
    public void attackTest() {

        this.blob.attack(this.blob);

        int actual = this.blob.getHealth();
        int expected = DEFAULT_HEALTH;

        Assert.assertTrue(DEFAULT_FAILED_TEST_MSG, expected > actual);
    }

    @Test
    public void attackWithDeathBlob() {
        Blob blob = Mockito.mock(Blob.class);
        Mockito.when(blob.getHealth()).thenReturn(ZERO);

        blob.attack(this.blob);

        int actual = this.blob.getHealth();
        int expected = DEFAULT_HEALTH;

        Assert.assertEquals(DEFAULT_FAILED_TEST_MSG, expected, actual);
    }
}