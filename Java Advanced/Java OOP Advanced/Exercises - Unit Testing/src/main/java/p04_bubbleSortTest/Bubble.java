package p04_bubbleSortTest;

import javax.naming.OperationNotSupportedException;

public class Bubble {

    private int[] arr;

    public Bubble(int... passedArr) throws OperationNotSupportedException {
        this.setArr(passedArr);
    }

    private void setArr(int[] passedArr) throws OperationNotSupportedException {
        if (passedArr == null) {
            throw new OperationNotSupportedException();
        }
        this.arr = passedArr;
    }

    public void sort() {
        int stepsIndex, index, temp;
        boolean swapped;
        int arrLength = this.arr.length;
        for (stepsIndex = 0; stepsIndex < arrLength - 1; stepsIndex++) {
            swapped = false;
            for (index = 0; index < (arrLength - stepsIndex - 1); index++) {
                if (this.arr[index] > this.arr[index + 1]) {
                    temp = this.arr[index];
                    this.arr[index] = this.arr[index + 1];
                    this.arr[index + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
    }

    public int[] getArr() {
        return this.arr;
    }
}
