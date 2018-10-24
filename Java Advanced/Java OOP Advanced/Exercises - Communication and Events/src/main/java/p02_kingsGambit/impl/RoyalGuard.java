package p02_kingsGambit.impl;

public class RoyalGuard extends BaseUnit {

    public RoyalGuard(String name) {
        super(name);
    }

    @Override
    public void update() {
        System.out.println(String.format("Royal Guard %s is defending!", super.getName()));
    }
}
