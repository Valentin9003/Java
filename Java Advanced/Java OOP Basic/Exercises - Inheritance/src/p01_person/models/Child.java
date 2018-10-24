package p01_person.models;

public class Child extends Person {

    private static final String INVALID_CHILD_AGE_EX_MESSAGE = "Child's age must be lesser than 15!";

    public Child(String name, int age) {
        super(name, age);
    }

    @Override
    protected void setAge(int age) {
        if (age >= 15) {
            throw new IllegalArgumentException(INVALID_CHILD_AGE_EX_MESSAGE);
        }
        super.setAge(age);
    }
}
