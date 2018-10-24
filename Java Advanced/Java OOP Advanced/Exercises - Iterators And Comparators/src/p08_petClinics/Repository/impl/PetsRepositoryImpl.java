package p08_petClinics.Repository.impl;

import p08_petClinics.Repository.interfaces.Repository;
import p08_petClinics.entity.Pet;

import java.util.LinkedHashMap;
import java.util.Map;

public class PetsRepositoryImpl implements Repository<Pet> {

    private Map<String, Pet> petsDb;

    public PetsRepositoryImpl() {
        this.petsDb = new LinkedHashMap<>();
    }


    @Override
    public void add(Pet pet) {
        this.petsDb.putIfAbsent(pet.getName(), pet);
    }

    @Override
    public boolean remove(Pet pet) {
        if (this.petsDb.containsKey(pet.getName())){
            this.petsDb.remove(pet.getName());
            return true;
        }
        return false;
    }

    @Override
    public Pet getByName(String name) {
        return this.petsDb.get(name);
    }
}
