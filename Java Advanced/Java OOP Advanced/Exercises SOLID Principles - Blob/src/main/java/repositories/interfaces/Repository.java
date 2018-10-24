package repositories.interfaces;

import java.util.Collection;

public interface Repository<T> {

    void add(T t);

    void remove(T t);

    T findByName(String name);

    Collection<T> findAll();
}
