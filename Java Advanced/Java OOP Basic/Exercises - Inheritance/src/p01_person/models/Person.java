package p01_person.models;

public class Person {

    private static final String NEGATIVE_AGE_EX_MESSAGE = "Age must be positive!";
    private static final String INVALID_NAME_LENGTH_EX_MESSAGE = "Name's length should not be less than 3 symbols!";

    private String name;
    private int age;

    public Person(String name, int age) {
        this.setName(name);
        this.setAge(age);
    }

    public String getName() {
        return this.name;
    }

    private void setName(String name) {
        if (name.length() < 3) {
            throw new IllegalArgumentException(INVALID_NAME_LENGTH_EX_MESSAGE);
        }
        this.name = name;
    }

    public int getAge() {
        return this.age;
    }

    protected void setAge(int age) {
        if (age < 1) {
            throw new IllegalArgumentException(NEGATIVE_AGE_EX_MESSAGE);
        }
        this.age = age;
    }

    @Override
    public String toString() {
        return String.format("Name: %s, Age: %d",
                this.getName(),
                this.getAge());

    }
}
