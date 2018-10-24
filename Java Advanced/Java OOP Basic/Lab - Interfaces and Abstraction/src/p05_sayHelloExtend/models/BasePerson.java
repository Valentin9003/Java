package p05_sayHelloExtend.models;

import java.io.Serializable;

public abstract class BasePerson implements Person, Serializable {

    private String name;

    protected BasePerson(String name) {
        this.setName(name);
    }

    @Override
    public String getName() {
        return this.name;
    }

    private void setName(String name) {
        this.name = name;
    }
}
