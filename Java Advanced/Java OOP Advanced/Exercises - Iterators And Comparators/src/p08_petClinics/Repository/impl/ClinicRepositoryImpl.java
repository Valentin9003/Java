package p08_petClinics.Repository.impl;

import p08_petClinics.Repository.interfaces.Repository;
import p08_petClinics.entity.Clinic;

import java.util.LinkedHashMap;
import java.util.Map;

public class ClinicRepositoryImpl implements Repository<Clinic> {

    private Map<String, Clinic> clinicDB;

    public ClinicRepositoryImpl() {
        this.clinicDB = new LinkedHashMap<>();
    }


    @Override
    public void add(Clinic clinic) {
        if (clinic != null) {
            this.clinicDB.putIfAbsent(clinic.getName(), clinic);
        }
    }

    @Override
    public boolean remove(Clinic clinic) {
        if (clinicDB.containsKey(clinic.getName())) {
            this.clinicDB.remove(clinic.getName());
            return true;
        }
        return false;
    }

    @Override
    public Clinic getByName(String name) {
        return this.clinicDB.get(name);
    }
}
