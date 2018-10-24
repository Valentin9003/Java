package com.company.birthdayCelebrations;

public class Robots extends Societies {

    public static final String DEFAULT_BIRTHDAY_DATE = null;

    private String model;

    public Robots(String model, String id) {
        super(id, DEFAULT_BIRTHDAY_DATE);
        this.setModel(model);
    }

    private void setModel(String model) {
        this.model = model;
    }

    public String getModel() {
        return model;
    }
}
