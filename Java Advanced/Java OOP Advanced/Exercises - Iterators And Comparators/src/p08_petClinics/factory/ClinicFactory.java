package p08_petClinics.factory;

import p08_petClinics.entity.Clinic;

public final class ClinicFactory {

    private ClinicFactory() {
    }

    public static Clinic createClinic(String name, int roomsCount) {
        return new Clinic(name, roomsCount);
    }
}
