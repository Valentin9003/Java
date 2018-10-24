package p05_sayHelloExtend.models;

public class Bulgarian extends BasePerson {

    public Bulgarian(String name) {
        super(name);
    }

    @Override
    public String sayHello() {
        return "К'во стаа брат";
    }
}
