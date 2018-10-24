package appDemo.transactions;

import java.util.List;

public interface MultyResultCommand<E> {

    List<E> execute();
}
