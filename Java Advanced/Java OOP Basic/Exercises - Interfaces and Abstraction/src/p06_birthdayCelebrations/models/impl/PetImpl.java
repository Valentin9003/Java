package p06_birthdayCelebrations.models.impl;

import p06_birthdayCelebrations.models.contracts.Pet;

public class PetImpl extends BaseMammal implements Pet {

    public PetImpl(String name, String birthdate) {
        super(name, birthdate);
    }
}
