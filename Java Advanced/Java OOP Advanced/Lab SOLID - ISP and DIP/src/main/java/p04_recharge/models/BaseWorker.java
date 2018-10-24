package p04_recharge.models;

import p04_recharge.contracts.Worker;

public abstract class BaseWorker implements Worker {

    private String id;
    private int workingHours;

    protected BaseWorker(String id) {
        this.id = id;
    }

    @Override
    public void work(int hours) {
        this.workingHours += hours;
    }
}
