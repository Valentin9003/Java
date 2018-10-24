package rpg_tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import rpg_lab.Axe;
import rpg_lab.Dummy;

public class TestAxe {

    private static final int DUMMY_HEALTH = 10;
    private static final int DUMMY_EXPERIENCE = 10;
    private static final int WEAPON_ATTACK = 5;
    private static final int WEAPON_DURABILITY = 10;
    private static final int BROKEN_WEAPON_DURABILITY = 0;

    private Dummy dummy;
    private Axe axe;

    @Before
    public void initializer() {
        this.dummy = new Dummy(DUMMY_HEALTH, DUMMY_EXPERIENCE);
        this.axe = new Axe(WEAPON_ATTACK, WEAPON_DURABILITY);
    }

    @Test
    public void ifWeaponLosesDurabilityAfterAttack() {
        this.axe.attack(this.dummy);
        long expectedDurability = WEAPON_DURABILITY - 1;
        Assert.assertEquals(
                "Durability loses doesn't work correct after attack.",
                expectedDurability,
                this.axe.getDurabilityPoints());
    }

    @Test(expected = IllegalStateException.class)
    public void attackingWithBrokenWeapon(){
        Axe weapon = new Axe(WEAPON_ATTACK, BROKEN_WEAPON_DURABILITY);
        weapon.attack(this.dummy);
    }
}
