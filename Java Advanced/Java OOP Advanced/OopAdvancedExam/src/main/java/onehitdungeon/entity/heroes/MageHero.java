package onehitdungeon.entity.heroes;

import onehitdungeon.interfaces.ArmorItem;
import onehitdungeon.interfaces.OffhandItem;
import onehitdungeon.interfaces.WeaponItem;

public class MageHero extends BaseHero {

    private int timesTrained;

    public MageHero(String name, WeaponItem weapon, OffhandItem offhand, ArmorItem armor) {
        super(name, weapon, offhand, armor);
        this.timesTrained = 0;
    }

    @Override
    public Integer getTotalBattlePower() {
        return ((super.getWeapon().getBattlePower()
                + super.getArmor().getBattlePower()
                - super.getOffhand().getBattlePower() ) * 3) / 4;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(String.format("%s - Lvl. %d ",
                this.getName(),
                this.timesTrained + 1));

        sb.append("Mage").append(System.lineSeparator());

        sb.append(String.format("* Staff - %d (BP)", this.getWeapon().getBattlePower()))
                .append(System.lineSeparator())
                .append(String.format("* Orb - %d (BP)", this.getOffhand().getBattlePower()))
                .append(System.lineSeparator())
                .append(String.format("* Cape - %d (BP)", this.getArmor().getBattlePower()))
                .append(System.lineSeparator())
                .append("####################")
                .append(System.lineSeparator())
                .append(String.format("Gold: %.2f", this.getGold()))
                .append(System.lineSeparator())
                .append(String.format("Upgrade cost: %.2f", this.getTotalPriceForUpgrade()));

        return sb.toString();
    }
}
