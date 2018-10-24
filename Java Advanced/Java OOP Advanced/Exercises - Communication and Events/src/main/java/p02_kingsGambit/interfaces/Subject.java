package p02_kingsGambit.interfaces;

public interface Subject {

    void addObserver(Observer o);

    void removeObserver(Observer o);

    void notifyAllObservers();
}
