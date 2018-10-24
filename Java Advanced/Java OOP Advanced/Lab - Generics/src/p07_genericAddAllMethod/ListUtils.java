package p07_genericAddAllMethod;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ListUtils {

    private static final String EMPTY_LIST_EX_MSG = "Empty list!";

    public ListUtils() {
    }

    public static <T extends Comparable> T getMin(List<T> list){
        if (list.isEmpty()) {
            throw new IllegalArgumentException(EMPTY_LIST_EX_MSG);
        }
        T min = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i).compareTo(min) < 0) {
                min = list.get(i);
            }
        }
        return min;
    }

    public static <T extends Comparable> T getMax(List<T> list){
        if (list.isEmpty()) {
            throw new IllegalArgumentException(EMPTY_LIST_EX_MSG);
        }
        T max = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i).compareTo(max) > 0) {
                max = list.get(i);
            }
        }
        return max;
    }

    public static Iterable<Integer> getNullIndices(List<?> list){
        Collection<Integer> nulls = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == null) {
                nulls.add(i);
            }
        }
        return nulls;
    }

    public static <T> void flatten(List<? super T> dest, List<List<? extends T>> src) {
        for (List<? extends T> inner : src) {
            dest.addAll(inner);
        }
    }

    public static <T> void addAll(List<? super T> destination, List<? extends T> source) {
        for (T element : source) {
            destination.add(element);
        }
    }
}
