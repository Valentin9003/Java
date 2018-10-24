package p09_collectionHierarchy.impl;

import p09_collectionHierarchy.contracts.AddRemoveCollection;

public class AddRemoveCollectionImpl extends AddCollectionImpl implements AddRemoveCollection {

    public AddRemoveCollectionImpl() {
        super();
    }

    @Override
    public String remove() {
        return super.getCollection().remove(super.getCollection().size() - 1);
    }

    @Override
    public int add(String str) {
        super.getCollection().add(0, str);

        return super.getCollection().indexOf(str);
    }

}
