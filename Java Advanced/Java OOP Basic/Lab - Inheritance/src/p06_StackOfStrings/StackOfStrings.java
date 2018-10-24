package p06_StackOfStrings;

import java.util.ArrayList;
import java.util.List;

public class StackOfStrings implements IStack {

    private List<String> data;

    public StackOfStrings() {
        this.data = new ArrayList<>();
    }

    @Override
    public void push(String item) {
        this.data.add(0, item);
    }

    @Override
    public String pop() {
        return data.remove(0);
    }

    @Override
    public String peek() {
        return this.data.get(0);
    }

    @Override
    public boolean isEmpty() {
        return this.data.size() == 0;
    }
}
