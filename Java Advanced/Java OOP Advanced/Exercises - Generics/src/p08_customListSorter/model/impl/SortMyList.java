package p08_customListSorter.model.impl;

import p08_customListSorter.model.interfaces.MyList;

public class SortMyList {

    private SortMyList() {
    }

    public static <T extends Comparable<T>> void sort(MyList<T> myList) {
        myList.sortAsc();
    }
}
