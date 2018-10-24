package p06_birthdayCelebrations.models.impl;


import p06_birthdayCelebrations.models.contracts.Citizen;

public class CitizenImpl extends BaseMammal implements Citizen {

    private int age;
    private String id;

    public CitizenImpl(String name, int age, String id, String birthdate) {
        super(name, birthdate);
        this.age = age;
        this.id = id;
    }

    @Override
    public String getId() {
        return this.id;
    }

}
