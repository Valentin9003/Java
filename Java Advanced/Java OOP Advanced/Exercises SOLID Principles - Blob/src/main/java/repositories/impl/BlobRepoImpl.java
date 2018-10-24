package repositories.impl;

import models.Blob;
import repositories.interfaces.Repository;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

public class BlobRepoImpl implements Repository<Blob> {

    private Map<String, Blob> blobDB;

    public BlobRepoImpl() {
        this.blobDB = new LinkedHashMap<>();
    }

    @Override
    public void add(Blob blob) {
        this.blobDB.putIfAbsent(blob.getName(), blob);
    }

    @Override
    public void remove(Blob blob) {
        this.blobDB.remove(blob.getName());
    }

    @Override
    public Blob findByName(String name) {
        return this.blobDB.get(name);
    }

    @Override
    public Collection<Blob> findAll() {
        return this.blobDB.values();
    }
}
