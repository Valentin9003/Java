package com.company.borderControl;

public class Robot extends Society {

    private String model;

    public Robot(String model, String id) {
        super(id);
        this.setModel(model);
    }

    private void setModel(String model) {
        this.model = model;
    }

    public String getModel() {
        return model;
    }
}
