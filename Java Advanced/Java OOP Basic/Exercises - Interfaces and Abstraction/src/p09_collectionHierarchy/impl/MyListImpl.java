package p09_collectionHierarchy.impl;

import p09_collectionHierarchy.contracts.MyList;

public class MyListImpl extends AddRemoveCollectionImpl implements MyList {

    public MyListImpl() {
        super();
    }

    @Override
    public String remove() {
        return super.getCollection().remove(0);
    }

    @Override
    public int used() {
        return this.getCollection().size();
    }
}
