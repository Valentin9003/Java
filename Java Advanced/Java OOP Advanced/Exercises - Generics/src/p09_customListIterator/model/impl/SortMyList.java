package p09_customListIterator.model.impl;

import p09_customListIterator.model.interfaces.MyList;

public class SortMyList {

    private SortMyList() {
    }

    public static <T extends Comparable<T>> void sort(MyList<T> myList) {
        myList.sortAsc();
    }
}
