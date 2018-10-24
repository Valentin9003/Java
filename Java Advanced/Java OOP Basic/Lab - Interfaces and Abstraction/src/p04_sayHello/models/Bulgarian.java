package p04_sayHello.models;

public class Bulgarian implements Person {

    private String name;

    public Bulgarian(String name) {
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
        return "К'во стаа брат";
    }
}
