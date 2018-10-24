package p04_listUtilities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Integer> integers = new ArrayList<>() {{add(1); add(2); add(3); add(4); add(5);}};

        Integer maxInt = ListUtils.getMax(integers);
        System.out.println(maxInt);

        List<String> strings = new ArrayList<>();
        Collections.addAll(strings, "a", "b", "c");

        String minStr = ListUtils.getMin(strings);
        System.out.println(minStr);
    }
}
