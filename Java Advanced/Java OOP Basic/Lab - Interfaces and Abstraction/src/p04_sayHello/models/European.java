package p04_sayHello.models;

public class European implements Person {

    private String name;

    public European(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String sayHello() {
        return "Hello";
    }
}
