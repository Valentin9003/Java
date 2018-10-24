package p01_eventImplementation.interfaces;

import p01_eventImplementation.implementations.EventNameChange;

public interface NameChangeListener {

    void handleChangedName(EventNameChange event);
}
