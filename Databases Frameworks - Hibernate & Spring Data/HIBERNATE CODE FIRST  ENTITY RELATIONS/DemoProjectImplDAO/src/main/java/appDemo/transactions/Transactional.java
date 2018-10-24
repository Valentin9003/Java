package appDemo.transactions;

import java.util.List;

public interface Transactional<E> {

    void runInTransaction(VoidCommand<E> command);

    E runInTransaction(Command<E> command);

    List<E> runInTransaction(MultyResultCommand<E> command);

}
