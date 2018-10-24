package p02_kingsGambit.impl;

import p02_kingsGambit.interfaces.Attackable;
import p02_kingsGambit.interfaces.Subject;

public class King extends BaseUnit implements Attackable {

    private Subject subject;

    public King(String name, Subject subject) {
        super(name);
        this.subject = subject;
    }

    @Override
    public void respondToAttack() {
        this.subject.notifyAllObservers();
    }

    @Override
    public void update() {
        System.out.println(String.format("King %s is under attack!", super.getName()));
    }
}
