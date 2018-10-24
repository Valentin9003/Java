package p04_bubbleSortTest;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

public class BubbleTest {

    private final String DEFAULT_MSG = "Test failed. Wrong: ";
    private final String DEFAULT_EXPECTED = "1, 2, 3, 4, 5, 6, 7, 8, 9, 10";

    private Bubble bubble;
    private int[] arr;

    @Before
    public void initializer() throws OperationNotSupportedException {
        this.arr = new int[] {2, 5, 3, 7, 1, 4, 8, 6, 10, 9};
        this.bubble = new Bubble(arr);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void constructorTestWithPassedNull() throws OperationNotSupportedException {
        this.bubble = new Bubble(null);
    }

    @Test
    public void sort() {
        this.bubble.sort();

        String actual =
                Arrays.stream(arr)
                        .mapToObj(String::valueOf)
                        .collect(Collectors.joining(", "));

        String expected = DEFAULT_EXPECTED;

        Assert.assertEquals(DEFAULT_MSG, expected, actual);
    }

    @Test
    public void getArrTest() {
        int actual = this.bubble.getArr()[5];
        int expected = this.arr[5];

        Assert.assertEquals(DEFAULT_MSG, expected, actual);
    }
}