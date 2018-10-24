package contracts;

import exeptions.DuplicateModelException;
import exeptions.NonExistentModelException;

public interface Repository<T> {

    void add(T item) throws DuplicateModelException;

    T getItemByModel(String model) throws NonExistentModelException;
}
