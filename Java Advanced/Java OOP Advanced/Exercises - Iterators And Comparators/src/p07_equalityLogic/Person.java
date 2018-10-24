package p07_equalityLogic;

import java.util.Objects;

public class Person implements Comparable<Person> {

    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public int compareTo(Person other) {
        int comp = this.getName().compareTo(other.getName());
        if (comp == 0) {
            comp = this.getAge() - other.getAge();
        }
        return comp;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (!(other instanceof Person)) return false;
        Person person = (Person) other;
        return getAge() == person.getAge() &&
                Objects.equals(getName(), person.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getAge());
    }
}
