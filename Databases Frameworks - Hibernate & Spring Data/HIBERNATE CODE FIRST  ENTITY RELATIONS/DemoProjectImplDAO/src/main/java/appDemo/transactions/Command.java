package appDemo.transactions;

public interface Command<E> {

    E execute();
}
