package p04_recharge.models;

public class Robot extends BaseWorker {

    private int capacity;
    private int currentPower;

    public Robot(String id, int capacity) {
        super(id);
        this.capacity = capacity;
        this.currentPower = capacity;
    }

    public int getCapacity() {
        return this.capacity;
    }

    public void setCurrentPower(int rechargingPower) {
        this.currentPower = rechargingPower;
    }

    @Override
    public void work(int hours) {
        if (hours > this.currentPower) {
            hours = currentPower;
        }

        super.work(hours);
        this.currentPower -= hours;
    }
}
