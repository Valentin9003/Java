package p08_petClinics.entity;

public class Pet {

    private final String INVALID_NAME_EX_MESSAGE = "Invalid clinic name! Need be String containing of alphabetical characters with length [1-50]!";
    private final String INVALID_YEARS_EX_MESSAGE = "Invalid pet years!";
    private final String INVALID_KIND_EX_MESSAGE = "Invalid pet kind! Need be String containing of alphabetical characters with length [1-50]!";

    private String name;
    private int age;
    private String kind;

    public Pet(String name, int age, String kind) {
        this.setName(name);
        this.setAge(age);
        this.setKind(kind);
    }

    private void setName(String name) {
        if (name.length() > 50 || !name.matches("[A-Za-z]+")){
            throw new IllegalArgumentException(INVALID_NAME_EX_MESSAGE);
        }
        this.name = name;
    }

    private void setAge(int age) {
        if (age < 1 || age > 100) {
            throw new IllegalArgumentException(INVALID_YEARS_EX_MESSAGE);
        }
        this.age = age;
    }

    private void setKind(String kind) {
        if (name.length() > 50 || !name.matches("[A-Za-z]+")){
            throw new IllegalArgumentException(INVALID_KIND_EX_MESSAGE);
        }
        this.kind = kind;
    }

    private String getKind() {
        return this.kind;
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    @Override
    public String toString() {
        return String.format("%s %d %s",
                this.getName(),
                this.getAge(),
                this.getKind());
    }
}
