package p05_nullFinder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Integer> integers = new ArrayList<>();
        Collections.addAll(integers, 1, 2, null, 2, null);

        Iterable<Integer> integerNulls = ListUtils.getNullIndices(integers);
        for (Integer integerNull : integerNulls) {
            System.out.print(integerNull + " ");
        }


        System.out.println();

        List<String> strings = new ArrayList<>();
        Collections.addAll(strings, "a", null, "c");

        Iterable<Integer> stringsNulls = ListUtils.getNullIndices(strings);
        for (Integer str : stringsNulls) {
            System.out.print(str + " ");
        }
    }
}
