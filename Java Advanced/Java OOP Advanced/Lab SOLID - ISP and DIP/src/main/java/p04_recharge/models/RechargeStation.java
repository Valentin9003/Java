package p04_recharge.models;

import p04_recharge.contracts.Rechargeable;

public class RechargeStation {

    public RechargeStation() {
    }

    public void recharge(Rechargeable rechargeable) {
        rechargeable.recharge();
    }
}
