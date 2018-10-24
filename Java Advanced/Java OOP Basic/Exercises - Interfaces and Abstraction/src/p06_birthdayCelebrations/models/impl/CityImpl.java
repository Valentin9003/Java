package p06_birthdayCelebrations.models.impl;

import p06_birthdayCelebrations.models.contracts.City;
import p06_birthdayCelebrations.models.contracts.Passport;

import java.util.LinkedList;
import java.util.List;

public class CityImpl implements City {

    private String fakeIdLastDigits;
    private List<String> detainedIds;

    public CityImpl(String fakeIdLastDigits) {
        this.fakeIdLastDigits = fakeIdLastDigits;
        this.detainedIds = new LinkedList<>();
    }

    @Override
    public void check(Passport passport) {
        if (passport.getId().endsWith(fakeIdLastDigits)) {
            /**if the passport is fake (have fake id) -> detained this one*/
            this.detainedIds.add(passport.getId());
        }
    }

    @Override
    public String toString() {
        StringBuilder detained = new StringBuilder();
        this.detainedIds
                .forEach(id -> detained.append(id)
                        .append(System.lineSeparator()));

        return detained.toString();
    }
}
