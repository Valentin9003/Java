package p01_eventImplementation.implementations;

import p01_eventImplementation.interfaces.NameChangeListener;

public class Handler implements NameChangeListener {

    @Override
    public void handleChangedName(EventNameChange event) {
        System.out.println("Dispatcher's name changed to " + event.getChangedName() + ".");
    }
}
