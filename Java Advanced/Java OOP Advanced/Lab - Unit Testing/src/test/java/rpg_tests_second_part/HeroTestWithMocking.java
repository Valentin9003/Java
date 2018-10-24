package rpg_tests_second_part;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import rpg_lab_part2.Axe;
import rpg_lab_part2.Hero;
import rpg_lab_part2.interfaces.Target;
import rpg_lab_part2.interfaces.Weapon;

import java.util.ArrayList;
import java.util.List;

public class HeroTestWithMocking {

    private static final int TARGET_XP = 10;
    private static final String HERO_NAME = "hero";
    private static final int WEAPON_ATTACK = 10;
    private static final int WEAPON_DURABILITY = 10;

    private Target fakeTarget;
    private Weapon fakeWeapon;

    @Before
    public void init() {
        this.fakeTarget = Mockito.mock(Target.class);
        this.fakeWeapon = Mockito.mock(Weapon.class);

        List<Weapon> weaponList = new ArrayList<Weapon>();
        weaponList.add(new Axe(WEAPON_ATTACK, WEAPON_DURABILITY));
        Mockito.when(this.fakeTarget.getPossibleLoot()).thenReturn(weaponList);
    }

    @Test
    public void attackGainsXpIfTargetIsDeath() {
        Mockito.when(this.fakeTarget.isDead()).thenReturn(true);
        Mockito.when(this.fakeTarget.giveExperience()).thenReturn(TARGET_XP);

        Hero hero = new Hero(HERO_NAME, this.fakeWeapon);
        hero.attack(this.fakeTarget);

        Assert.assertEquals("Wrong experience", TARGET_XP, hero.getExperience());
    }

    @Test
    public void testHeroGettingLootUponKillingTarget() {
        Mockito.when(this.fakeTarget.isDead()).thenReturn(true);

        Hero hero = new Hero(HERO_NAME, this.fakeWeapon);
        hero.attack(this.fakeTarget);

        Assert.assertEquals("Wrong inventory size.", 1, hero.getInventorySize());
    }
}
