package com.company.OldestFamilyMember;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Family {

    private List<Person> people;

    public Family() {
        this.people = new ArrayList<>();
    }

    public void addFamilyMember(Person person) {
        people.add(person);
    }

    public Person getOldestMember() {

        List<Person> sortedListByYears = people
                .stream()
                .sorted((p1, p2) -> p2.getAge().compareTo(p1.getAge()))
                .collect(Collectors.toList());

        return sortedListByYears.get(0);
    }
}
