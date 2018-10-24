package rpg_lab_part2;

import rpg_lab_part2.interfaces.Target;
import rpg_lab_part2.interfaces.Weapon;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Hero {

    private String name;
    private int experience;
    private Weapon weapon;
    private List<Weapon> inventory;

    //•	Make Hero class testable (use Dependency Injection)
    public Hero(String name, Weapon weapon) {
        this.name = name;
        this.experience = 0;
        this.weapon = weapon;
        this.inventory = new ArrayList<Weapon>();
    }

    public String getName() {
        return this.name;
    }

    public int getExperience() {
        return this.experience;
    }

    public Weapon getWeapon() {
        return this.weapon;
    }

    public void attack(Target target) {
        this.weapon.attack(target);

        if (target.isDead()) {
            this.experience += target.giveExperience();
            lootWeaponFromTarget(target);
        }
    }

    private void lootWeaponFromTarget(Target target) {
        List<Weapon> possibleLoot = target.getPossibleLoot();
        Random random = new Random();
        int randomIndex = random.nextInt(possibleLoot.size());

        this.inventory.add(possibleLoot.get(randomIndex));
    }

    public Iterable<Weapon> getInventory() {
        return this.inventory;
    }

    public int getInventorySize() {
        return this.inventory.size();
    }
}
