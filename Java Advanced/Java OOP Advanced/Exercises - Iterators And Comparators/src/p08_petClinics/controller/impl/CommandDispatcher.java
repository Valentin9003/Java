package p08_petClinics.controller.impl;

import p08_petClinics.Repository.impl.ClinicRepositoryImpl;
import p08_petClinics.Repository.impl.PetsRepositoryImpl;
import p08_petClinics.Repository.interfaces.Repository;
import p08_petClinics.controller.interfaces.Dispatcher;
import p08_petClinics.entity.Clinic;
import p08_petClinics.entity.Pet;
import p08_petClinics.factory.ClinicFactory;
import p08_petClinics.factory.PetFactory;
import p08_petClinics.until.Config;

public class CommandDispatcher implements Dispatcher {

    private Repository<Pet> petRepository;
    private Repository<Clinic> clinicRepository;

    public CommandDispatcher() {
        this.petRepository = new PetsRepositoryImpl();
        this.clinicRepository = new ClinicRepositoryImpl();
    }

    @Override
    public void createPet(String name, int age, String kind) {
        Pet pet = PetFactory.createPet(name, age, kind);
        this.petRepository.add(pet);
    }

    @Override
    public void createClinic(String name, int rooms) {
        Clinic clinic = ClinicFactory.createClinic(name, rooms);
        this.clinicRepository.add(clinic);
    }

    @Override
    public boolean add(String petName, String clinicName) {
        Pet pet = this.petRepository.getByName(petName);
        Clinic clinic = this.clinicRepository.getByName(clinicName);

        boolean isAdded = clinic.addPet(pet);
        if (isAdded) {
            this.petRepository.remove(pet);
        }
        return isAdded;
    }

    @Override
    public boolean release(String clinicName) {
        Clinic clinic = this.clinicRepository.getByName(clinicName);
        return clinic.release();
    }

    @Override
    public boolean hasEmptyRooms(String clinicName) {
        Clinic clinic = this.clinicRepository.getByName(clinicName);
        return clinic.hasEmptyRoom();
    }

    @Override
    public String print(String clinicName) {
        Clinic clinic = this.clinicRepository.getByName(clinicName);
        return clinic.toString();
    }

    @Override
    public String print(String clinicName, int roomNumber) {
        Clinic clinic = this.clinicRepository.getByName(clinicName);
        int roomIndex = roomNumber - 1;
        Pet petInClinicRoom = clinic.getRoomByIndex(roomIndex);
        if (petInClinicRoom == null) {
            return Config.EMPTY_ROOM;
        }
        return petInClinicRoom.toString();
    }
}
