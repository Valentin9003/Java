package p05_comparingObjects;

public class Person implements Comparable<Person> {

    private String name;
    private int age;
    private String town;

    public Person(String name, int age, String town) {
        this.name = name;
        this.age = age;
        this.town = town;
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    public String getTown() {
        return this.town;
    }

    @Override
    public int compareTo(Person other) {
        int comp = this.getName().compareTo(other.getName());
        if (comp == 0) {
            comp = Integer.compare(this.getAge(), other.getAge());
            if (comp == 0) {
                comp = this.getTown().compareTo(other.getTown());
            }
        }
        return comp;
    }
}
