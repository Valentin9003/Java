package rpg_tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import rpg_lab.Axe;
import rpg_lab.Dummy;

public class DummyTests {

    private static final int DUMMY_HEALTH = 10;
    private static final int DUMMY_EXPERIENCE = 10;
    private static final int WEAPON_ATTACK = 5;
    private static final int WEAPON_DURABILITY = 10;

    private Dummy dummy;
    private Axe axe;

    @Before
    public void initializer() {
        this.dummy = new Dummy(DUMMY_HEALTH, DUMMY_EXPERIENCE);
        this.axe = new Axe(WEAPON_ATTACK, WEAPON_DURABILITY);
    }

    @Test
    public void dummyLosesHealthIfAttacked() {
        this.axe.attack(this.dummy);
        long expectedHealthAfterAttack = DUMMY_HEALTH - WEAPON_ATTACK;
        Assert.assertEquals(
                "After attack dummy doesn't lose correct health.",
                expectedHealthAfterAttack,
                this.dummy.getHealth());
    }

    @Test(expected = IllegalStateException.class)
    public void deadDummyThrowsExceptionIfAttacked() {
        this.axe.attack(this.dummy);
        this.axe.attack(this.dummy);
        this.axe.attack(this.dummy);
    }

    @Test
    public void deadDummyCanGiveXP() {
        this.axe.attack(this.dummy);
        this.axe.attack(this.dummy);
        Assert.assertEquals(
                "Death Dummy doesn't give correct his XP.",
                DUMMY_EXPERIENCE,
                dummy.giveExperience());
    }

    @Test(expected = IllegalStateException.class)
    public void aliveDummyCantGiveXP() {
        this.axe.attack(this.dummy);
        this.dummy.giveExperience();
    }
}
