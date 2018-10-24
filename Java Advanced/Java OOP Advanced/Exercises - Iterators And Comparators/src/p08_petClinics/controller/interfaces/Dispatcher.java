package p08_petClinics.controller.interfaces;

public interface Dispatcher {

    void createPet(String name, int age, String kind);

    void createClinic(String name, int rooms);

    boolean add(String petName, String clinicName);

    boolean release(String clinicName);

    boolean hasEmptyRooms(String clinicName);

    String print(String clinicName);

    String print(String clinicName, int room);

}
