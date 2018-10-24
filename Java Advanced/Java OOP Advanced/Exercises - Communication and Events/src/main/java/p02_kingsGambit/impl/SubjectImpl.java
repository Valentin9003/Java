package p02_kingsGambit.impl;

import p02_kingsGambit.interfaces.Observer;
import p02_kingsGambit.interfaces.Subject;

import java.util.LinkedList;
import java.util.List;

public class SubjectImpl implements Subject {

    private List<Observer> observers;

    public SubjectImpl() {
        this.observers = new LinkedList<>();
    }

    @Override
    public void addObserver(Observer o) {
        this.observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        this.observers.remove(o);
    }

    @Override
    public void notifyAllObservers() {
        this.observers.forEach(Observer::update);
    }
}
