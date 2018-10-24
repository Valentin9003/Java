package repositories.impl;

import models.Blob;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import repositories.interfaces.Repository;

import java.lang.reflect.Field;
import java.util.Collection;
import java.util.Map;

import static org.junit.Assert.*;

public class BlobRepoImplTest {

    private final int ZERO = 0;
    private final String DEFAULT_BLOB_NAME = "Pesho";
    private final String DEFAULT_NEW_BLOB_NAME = "Tosho";
    private final int DEFAULT_HEALTH = 100;
    private final int DEFAULT_DAMAGE = 200;

    private Repository<Blob> repository;
    private Blob blob;

    @Before
    public void init() {
        this.repository = new BlobRepoImpl();
        this.blob = Mockito.mock(Blob.class);
    }

    @Test
    @SuppressWarnings("unchecked")
    public void addTestIfCollectionSizeGrow() {
        Mockito.when(this.blob.getName()).thenReturn(DEFAULT_BLOB_NAME);

        this.repository.add(this.blob);

        try {
            Field field = this.repository.getClass().getDeclaredField("blobDB");
            field.setAccessible(true);

            Map<String, Blob> blobMap = (Map<String, Blob>) field.get(this.repository);

            int actual = blobMap.size();
            int expected = 1;

            Assert.assertEquals(expected,actual);
        } catch (NoSuchFieldException
                | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void addTestByCollectionSize() {
        Mockito.when(this.blob.getName()).thenReturn(DEFAULT_BLOB_NAME);

        this.repository.add(this.blob);

        int actual = this.repository.findAll().size();
        int expected = 1;

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void addTest() {
        Mockito.when(this.blob.getName()).thenReturn(DEFAULT_BLOB_NAME);
        Mockito.when(this.blob.getHealth()).thenReturn(DEFAULT_HEALTH);
        Mockito.when(this.blob.getDamage()).thenReturn(DEFAULT_DAMAGE);

        this.repository.add(this.blob);

        Blob blobByName = this.repository.findByName(DEFAULT_BLOB_NAME);

        boolean check = blobByName.getHealth() == DEFAULT_HEALTH
                && blobByName.getDamage() == DEFAULT_DAMAGE;

        Assert.assertTrue(check);
    }

    @Test
    public void removeTestMapSize() {
        Mockito.when(this.blob.getName()).thenReturn(DEFAULT_BLOB_NAME);

        this.repository.add(this.blob);

        try {
            Field field = this.repository.getClass().getDeclaredField("blobDB");
            field.setAccessible(true);

            this.repository.remove(this.blob);

            Map<String, Blob> blobMap = (Map<String, Blob>) field.get(this.repository);

            int actual = blobMap.size();
            int expected = 0;

            Assert.assertEquals(expected,actual);
        } catch (NoSuchFieldException
                | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void removeTestCollectionSize() {
        Mockito.when(this.blob.getName()).thenReturn(DEFAULT_BLOB_NAME);

        this.repository.add(this.blob);
        this.repository.remove(this.blob);

        int actual = this.repository.findAll().size();
        int expected = 0;

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void findByName() {
        Mockito.when(this.blob.getDamage()).thenReturn(DEFAULT_DAMAGE);
        Mockito.when(this.blob.getName()).thenReturn(DEFAULT_BLOB_NAME);

        Blob secondBlob = Mockito.mock(Blob.class);
        Mockito.when(secondBlob.getName()).thenReturn(DEFAULT_NEW_BLOB_NAME);
        Mockito.when(secondBlob.getDamage()).thenReturn(ZERO);

        this.repository.add(this.blob);
        this.repository.add(secondBlob);

        Blob findBlob = this.repository.findByName(DEFAULT_BLOB_NAME);

        int actual = findBlob.getDamage();
        int expected = DEFAULT_DAMAGE;

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void findAll() {
        Blob secondBlob = Mockito.mock(Blob.class);
        Mockito.when(secondBlob.getName()).thenReturn(DEFAULT_NEW_BLOB_NAME);

        this.repository.add(this.blob);
        this.repository.add(secondBlob);

        Collection<Blob> all = this.repository.findAll();

        int actual = all.size();
        int expected = 2;

        Assert.assertEquals(expected, actual);
    }
}