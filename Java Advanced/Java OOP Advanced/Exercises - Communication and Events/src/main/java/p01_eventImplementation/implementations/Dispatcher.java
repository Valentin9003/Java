package p01_eventImplementation.implementations;

import p01_eventImplementation.interfaces.NameChangeListener;

import java.util.ArrayList;
import java.util.List;

public class Dispatcher {

    private String name;
    List<NameChangeListener> listeners;

    public Dispatcher() {
        this.listeners = new ArrayList<>();
    }

    public void setName(EventNameChange nameChange) {
        this.name = nameChange.getChangedName();

        this.fireNameChangeEvent(nameChange);
    }

    public void addNameChangeListener(NameChangeListener listener) {
        // Add the listener to the list of registered listeners
        listeners.add(listener);
    }

    public void removeNameChangeListener(NameChangeListener listener) {
        // Remove the listener from the list of the registered listeners
        this.listeners.remove(listener);
    }

    public void fireNameChangeEvent(EventNameChange nameChange) {
        // Notify each of the listeners in the list of registered listeners
        this.listeners.forEach(listener -> listener.handleChangedName(nameChange));
    }

}
