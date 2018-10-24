package p10_infernoInfinity.entity;

import p10_infernoInfinity.annotations.ClassInfoAnnotation;
import p10_infernoInfinity.enums.Gem;
import p10_infernoInfinity.enums.WeaponType;

@ClassInfoAnnotation(
        author = "Ivelin",
        revision = 3,
        description = "Used for Java OOP Advanced course - Enumerations and Annotations.",
        reviewers = {"Pesho", "Svetlio"})
public class Weapon implements Comparable<Weapon> {

    private String name;
    private WeaponType weaponType;
    private Gem[] gems;

    public Weapon(String name, String weaponType) {
        this.setName(name);
        this.setWeaponType(weaponType);
        this.gems = new Gem[this.weaponType.getSockets()];
    }

    private void setName(String name) {
        this.name = name;
    }

    private void setWeaponType(String weaponType) {
        this.weaponType = Enum.valueOf(WeaponType.class, weaponType.toUpperCase());
    }

    public String getName() {
        return this.name;
    }

    public void addGems(int socketIndex, String gemType) {
        if (socketIndex >= 0 && socketIndex < this.gems.length) {
            Gem gem = Gem.valueOf(gemType.toUpperCase());
            this.gems[socketIndex] = gem;
        }
    }

    public void removeGems(int socketIndex) {
        if (socketIndex >= 0 && socketIndex < this.gems.length) {
            this.gems[socketIndex] = null;
        }
    }

    public int getMinDamage() {
        int minDamage = this.weaponType.getMinDamage();
        minDamage += this.getStrength() * 2;
        minDamage += this.getAgility();
        return minDamage;
    }

    public int getMaxDamage() {
        int maxDamage = this.weaponType.getMaxDamage();
        maxDamage += this.getStrength() * 3;
        maxDamage += this.getAgility() * 4;
        return maxDamage;
    }

    public int getStrength() {
        int strength = 0;
        for (Gem gem : this.gems) {
            if (gem != null) {
                strength += gem.getStrength();
            }
        }
        return strength;
    }

    public int getAgility() {
        int agility = 0;
        for (Gem gem : this.gems) {
            if (gem != null) {
                agility += gem.getAgility();
            }
        }
        return agility;
    }

    public int getVitality() {
        int vitality = 0;
        for (Gem gem : this.gems) {
            if (gem != null) {
                vitality += gem.getVitality();
            }
        }
        return vitality;
    }

    public double getItemLevel() {
        return ((this.getMinDamage() + this.getMaxDamage()) / 2.0)
                + this.getStrength() + this.getAgility() + this.getVitality();
    }

    @Override
    public int compareTo(Weapon other) {
        return Double.compare(this.getItemLevel(), other.getItemLevel());
    }

    @Override
    public String toString() {
        return String.format("%s: %d-%d Damage, +%d Strength, +%d Agility, +%d Vitality",
                this.getName(),
                this.getMinDamage(),
                this.getMaxDamage(),
                this.getStrength(),
                this.getAgility(),
                this.getVitality());
    }
}
