package com.company.PrintPeople;

public class Person implements Comparable<Person>{

    private String name;
    private Integer age;
    private String occupation;

    public Person(String name, Integer age, String occupation) {
        this.name = name;
        this.age = age;
        this.occupation = occupation;
    }

    @Override
    public String toString() {
        return String.format("%s - age: %d, occupation: %s", this.name, this.age, this.occupation);
    }

    @Override
    public int compareTo(Person person) {
        return Double.compare(this.age, person.age);
    }
}
