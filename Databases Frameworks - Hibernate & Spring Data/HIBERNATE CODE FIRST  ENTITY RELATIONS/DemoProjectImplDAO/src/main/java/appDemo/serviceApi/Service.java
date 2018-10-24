package appDemo.serviceApi;

import java.util.List;

public interface Service<E, K> {

    E findById(Class<E> serviceClass, K id);

    void remove(E object);

    List<E> findAll(Class<E> serviceClass);

    void save(E object);

}
