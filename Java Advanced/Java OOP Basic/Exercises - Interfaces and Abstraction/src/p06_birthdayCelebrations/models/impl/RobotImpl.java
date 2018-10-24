package p06_birthdayCelebrations.models.impl;

import p06_birthdayCelebrations.models.contracts.Robot;

public class RobotImpl implements Robot {

    private String model;
    private String id;

    public RobotImpl(String model, String id) {
        this.model = model;
        this.id = id;
    }

    @Override
    public String getId() {
        return this.id;
    }
}
