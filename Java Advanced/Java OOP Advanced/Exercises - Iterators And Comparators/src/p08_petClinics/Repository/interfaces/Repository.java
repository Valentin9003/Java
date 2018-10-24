package p08_petClinics.Repository.interfaces;

public interface Repository<T> {

    void add(T t);

    boolean remove(T t);

    T getByName(String name);
}
