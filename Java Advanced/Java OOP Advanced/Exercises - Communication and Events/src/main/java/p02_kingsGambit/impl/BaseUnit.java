package p02_kingsGambit.impl;

import p02_kingsGambit.interfaces.Observer;

public abstract class BaseUnit implements Observer {

    private String name;

    public BaseUnit(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
