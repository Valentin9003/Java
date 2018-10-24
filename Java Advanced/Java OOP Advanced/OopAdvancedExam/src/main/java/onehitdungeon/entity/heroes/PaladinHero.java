package onehitdungeon.entity.heroes;

import onehitdungeon.interfaces.ArmorItem;
import onehitdungeon.interfaces.OffhandItem;
import onehitdungeon.interfaces.WeaponItem;

public class PaladinHero extends BaseHero {

    private int timesTrained;

    public PaladinHero(String name, WeaponItem weapon, OffhandItem offhand, ArmorItem armor) {
        super(name, weapon, offhand, armor);
        this.timesTrained = 0;
    }

    @Override
    public Integer getTotalBattlePower() {
        return ((super.getWeapon().getBattlePower()
                + super.getOffhand().getBattlePower()
                + super.getArmor().getBattlePower()) * 4) / 9;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(String.format("%s - Lvl. %d ",
                this.getName(),
                this.timesTrained + 1));

        sb.append("Paladin").append(System.lineSeparator());

        sb.append(String.format("* Mace - %d (BP)", this.getWeapon().getBattlePower()))
                .append(System.lineSeparator())
                .append(String.format("* Shield - %d (BP)", this.getOffhand().getBattlePower()))
                .append(System.lineSeparator())
                .append(String.format("* Cuirass - %d (BP)", this.getArmor().getBattlePower()))
                .append(System.lineSeparator())
                .append("####################")
                .append(System.lineSeparator())
                .append(String.format("Gold: %.2f", this.getGold()))
                .append(System.lineSeparator())
                .append(String.format("Upgrade cost: %.2f", this.getTotalPriceForUpgrade()));

        return sb.toString();
    }
}
