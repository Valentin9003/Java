package p03_iteratorTest;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import javax.naming.OperationNotSupportedException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.junit.Assert.*;

public class ListIteratorTest {

    private final String DEFAULT_MSG = "Test failed. Wrong: ";
    private final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    private final int DEFAULT_LETTER_INDEXES = 52;
    private final int DEFAULT_MIN_NAME_LENGTH = 4;
    private final int DEFAULT_NAME_LENGTH = 15;

    private ListIterator listIterator;

    @Before
    public void initializer() throws Exception {
        List<String> stringList = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            stringList.add(createString());
        }
        this.listIterator = new ListIterator(stringList);
    }

    private String createString() {
        Random random = new Random();
        int nameLength = 0;
        while (nameLength < DEFAULT_MIN_NAME_LENGTH) {
            nameLength = random.nextInt(DEFAULT_NAME_LENGTH);
        }
        StringBuilder nameBuilder = new StringBuilder();
        for (int nameLetter = 0; nameLetter < nameLength; nameLetter++) {
            int letterIndex = random.nextInt(DEFAULT_LETTER_INDEXES);
            char letter = ALPHABET.charAt(letterIndex);
            nameBuilder.append(letter);
        }
        return nameBuilder.toString();
    }

    @Test
    public void moveIfHasNextElement() {
        Assert.assertTrue(this.listIterator.move());
    }

    @Test
    public void moveIfThereIsNoNextElement() {
        this.listIterator.move();
        Assert.assertFalse(this.listIterator.move());
    }

    @Test
    public void hasNextIfHasNextElement() {
        Assert.assertTrue(this.listIterator.hasNext());
    }

    @Test
    public void hasNextIfTheIndexIsAlreadyAtTheLastElement() {
        this.listIterator.move();
        Assert.assertFalse(this.listIterator.hasNext());
    }

    @Test
    @SuppressWarnings("unchecked")
    public void printTest() {
        Class<?> clazz = this.listIterator.getClass();
        try {
            Field field = clazz.getDeclaredField("collection");
            field.setAccessible(true);
            List<String> buffList = (List<String>) field.get(this.listIterator);

            String actual = this.listIterator.print();
            String expected = buffList.get(0);

            Assert.assertEquals(DEFAULT_MSG, expected, actual);

        } catch (NoSuchFieldException |
                IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void printOnCollectionWithoutElements() throws OperationNotSupportedException {
        ListIterator iterator = new ListIterator(new ArrayList<>());
        iterator.print();
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testConstructorWithPassedNull() throws OperationNotSupportedException {
        ListIterator listIteratorTest = new ListIterator(null);
    }

    @Test
    public void testConstructorWithPassedEmptyCollection() throws OperationNotSupportedException {
        ListIterator listIteratorTest = new ListIterator(new ArrayList<>());

        Assert.assertFalse(listIteratorTest.hasNext());
    }

    @Test
    public void testConstructorWithCollection() {
        Assert.assertTrue(this.listIterator.hasNext());
    }
}