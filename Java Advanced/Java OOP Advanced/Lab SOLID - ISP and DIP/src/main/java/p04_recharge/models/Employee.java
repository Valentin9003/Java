package p04_recharge.models;

import p04_recharge.contracts.Sleeper;

public class Employee extends BaseWorker implements Sleeper {

    public Employee(String id) {
        super(id);
    }

    public void sleep() {
        // sleep...
    }

}
