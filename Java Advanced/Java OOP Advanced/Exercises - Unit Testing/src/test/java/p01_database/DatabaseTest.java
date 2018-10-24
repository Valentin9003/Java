package p01_database;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;
import java.util.Arrays;
import java.util.Random;

public class DatabaseTest {

    private static final String DEFAULT_MSG = "Test failed. Wrong: ";
    private static final int DEFAULT_ARR_LENGTH = 16;
    private static final int DEFAULT_ELEMENT = 101010;
    private static final int LAST_INDEX_AFTER_INIT = 13;

    private Database db;

    @Before
    public void init() throws Exception {
        Integer[] arr = new Integer[DEFAULT_ARR_LENGTH];
        fillArr(arr);
        this.db = new Database(arr);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testConstructorIfGivenArraySizeIsDifferentFromDefault() throws OperationNotSupportedException {
        Integer[] arr = new Integer[DEFAULT_ARR_LENGTH + 1];
        Database database = new Database(arr);
    }

    @Test
    public void testIfConstructorCreateCorrectPassedArr() throws OperationNotSupportedException {
        Integer[] arr = new Integer[DEFAULT_ARR_LENGTH];
        Database database = new Database(arr);

        Assert.assertTrue(isAllElementsNull(database.fetch()));
    }

    @Test
    public void testConstructorCreateCorrectArrLength() throws OperationNotSupportedException {
        Integer[] arr = new Integer[DEFAULT_ARR_LENGTH];
        Database database = new Database(arr);

        int actual = database.fetch().length;
        int expected = DEFAULT_ARR_LENGTH;
        Assert.assertEquals(DEFAULT_MSG, expected, actual);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void addElementToFullArr() throws OperationNotSupportedException {
        this.db.addElement(DEFAULT_ELEMENT);
        this.db.addElement(DEFAULT_ELEMENT);
        this.db.addElement(DEFAULT_ELEMENT);
    }

    @Test
    public void addElement() throws OperationNotSupportedException {
        this.db.addElement(DEFAULT_ELEMENT);

        boolean contains = Arrays.asList(this.db.fetch()).contains(DEFAULT_ELEMENT);
        Assert.assertTrue(contains);
    }

    @Test
    public void addElementToLastIndex() throws OperationNotSupportedException {
        this.db.addElement(DEFAULT_ELEMENT);

        int actual = this.db.fetch()[LAST_INDEX_AFTER_INIT + 1];
        int expected = DEFAULT_ELEMENT;

        Assert.assertEquals(DEFAULT_MSG, expected, actual);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void removeElementFromEmptyArr() throws OperationNotSupportedException {
        Database database = new Database();
        database.removeElement();
    }

    @Test
    public void removeElement() throws OperationNotSupportedException {
        this.db.removeElement();

        Integer actual = this.db.fetch()[LAST_INDEX_AFTER_INIT];

        Assert.assertNull(DEFAULT_MSG, actual);
    }

    @Test
    public void fetch() {
        Integer[] fetch = this.db.fetch();

        int actual = fetch.length;
        int expected = DEFAULT_ARR_LENGTH;

        Assert.assertEquals(DEFAULT_MSG, expected, actual);
    }

    private void fillArr(Integer[] arr) {
        Random random = new Random();
        for (int index = 0; index < DEFAULT_ARR_LENGTH - 2; index++) {
            arr[index] = random.nextInt(251);
        }
    }

    private boolean isAllElementsNull(Integer[] fetch) {
        for (Integer integer : fetch) {
            if (integer != null) {
                return false;
            }
        }
        return true;
    }
}