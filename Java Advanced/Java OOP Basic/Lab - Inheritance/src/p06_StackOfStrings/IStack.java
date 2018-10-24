package p06_StackOfStrings;

public interface IStack {

    void push(String item);

    String pop();

    String peek();

    boolean isEmpty();
}
