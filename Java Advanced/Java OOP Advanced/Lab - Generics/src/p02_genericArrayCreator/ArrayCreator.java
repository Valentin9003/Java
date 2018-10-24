package p02_genericArrayCreator;

import java.lang.reflect.Array;

public class ArrayCreator {

    public ArrayCreator() {
    }

    public static <T> T[] create(int length, T item){
        T[] arr = (T[]) new Object[length];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = item;
        }

        return arr;
    }

    public static <T> T[] create(Class<T> clazz, int length, T item){
        T[] arr = (T[]) Array.newInstance(clazz, length);

        for (int i = 0; i < arr.length; i++) {
            arr[i] = item;
        }

        return arr;
    }
}
