package rpg_tests_second_part;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import rpg_lab_part2.Hero;
import rpg_lab_part2.interfaces.Target;
import rpg_lab_part2.interfaces.Weapon;

import java.util.List;

public class HeroTests {

    private static final int TARGET_XP = 10;
    private static final String HERO_NAME = "hero";

    private Target fakeTarget;
    private Weapon fakeWeapon;

    @Before
    public void initializer() {
        this.fakeTarget = new Target() {
            public List<Weapon> getPossibleLoot() {
                return null;
            }

            public int getHealth() {
                return 0;
            }

            public void takeAttack(int attackPoints) {

            }

            public int giveExperience() {
                return TARGET_XP;
            }

            public boolean isDead() {
                return true;
            }
        };

        this.fakeWeapon = new Weapon() {
            public int getAttackPoints() {
                return 10;
            }

            public int getDurabilityPoints() {
                return 0;
            }

            public void attack(Target target) {

            }
        };
    }

    @Test
    public void attackGainsXpIfTargetIsDeath() {
        Hero hero = new Hero(HERO_NAME, this.fakeWeapon);
        hero.attack(this.fakeTarget);
        Assert.assertEquals(
                "Wrong experience",
                TARGET_XP,
                hero.getExperience());
    }
}
