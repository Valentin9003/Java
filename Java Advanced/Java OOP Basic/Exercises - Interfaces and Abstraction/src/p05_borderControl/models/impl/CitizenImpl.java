package p05_borderControl.models.impl;


import p05_borderControl.models.contracts.Citizen;

public class CitizenImpl implements Citizen {

    private String name;
    private int age;
    private String id;

    public CitizenImpl(String name, int age, String id) {
        this.name = name;
        this.age = age;
        this.id = id;
    }

    @Override
    public String getId() {
        return this.id;
    }
}
