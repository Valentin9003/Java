package p08_petClinics.factory;

import p08_petClinics.entity.Pet;

public final class PetFactory {

    private PetFactory() {
    }

    public static Pet createPet(String name, int age, String kind) {
        return new Pet(name, age, kind);
    }
}
