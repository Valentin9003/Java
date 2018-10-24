package p05_sayHelloExtend.models;

public class Chinese extends BasePerson {

    public Chinese(String name) {
        super(name);
    }

    @Override
    public String sayHello() {
        return "你好";
    }
}
