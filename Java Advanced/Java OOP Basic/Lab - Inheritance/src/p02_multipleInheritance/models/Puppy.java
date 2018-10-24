package p02_multipleInheritance.models;

import p02_multipleInheritance.models.interfaces.PuppyInterface;

public class Puppy extends Dog implements PuppyInterface {

    private static final String DEFAULT_WEEP = "weeping...";

    public Puppy() {
    }

    @Override
    public void weep() {
        System.out.println(DEFAULT_WEEP);
    }
}
