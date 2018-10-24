package p04_recharge.models;

import p04_recharge.contracts.Rechargeable;

public class MyRobot extends Robot implements Rechargeable {

    public MyRobot(String id, int capacity) {
        super(id, capacity);
    }

    @Override
    public void recharge() {
        super.setCurrentPower(super.getCapacity());
    }
}
