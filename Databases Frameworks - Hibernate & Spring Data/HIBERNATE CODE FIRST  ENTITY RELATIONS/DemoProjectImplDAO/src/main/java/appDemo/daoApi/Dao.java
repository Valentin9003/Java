package appDemo.daoApi;

import java.util.List;

public interface Dao<E, K> {

    E findById(Class<E> entityClass, K primaryKey);

    void remove(E entity);

    List<E> findAll(Class<E> entityClass);

    void save(E entity);
}
