package service.commands;

import java.util.List;

public interface ICommandExecutor<E, K> {

    E findById(Class<E> entityClass, K primaryKey);

    void remove(E entity);

    List<E> findAll(Class<E> entityClass);

    void save(E entity);
}
