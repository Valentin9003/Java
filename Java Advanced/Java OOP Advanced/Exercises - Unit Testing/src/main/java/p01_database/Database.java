package p01_database;

import javax.naming.OperationNotSupportedException;

public class Database {
    private final int DEFAULT_CAPACITY = 16;

    private Integer[] storedIntegers;
    private int cursor;

    public Database(Integer... numbers) throws OperationNotSupportedException {
        this.storedIntegers = new Integer[DEFAULT_CAPACITY];
        this.setStoredIntegers(numbers);
    }

    private void setStoredIntegers(Integer[] numbers) throws OperationNotSupportedException {
        if (numbers.length != DEFAULT_CAPACITY) {
            throw new OperationNotSupportedException();
        }

        for (int index = 0; index < DEFAULT_CAPACITY; index++) {
            this.storedIntegers[index] = numbers[index];

            if (numbers[index] != null) {
                this.cursor = index;
            }
        }
    }

    public void addElement(Integer number) throws OperationNotSupportedException {
        if (number == null) {
            throw new OperationNotSupportedException();
        }
        if (this.cursor == (DEFAULT_CAPACITY - 1)) {
            throw new OperationNotSupportedException();
        }

        this.storedIntegers[++this.cursor] = number;
    }

    public void removeElement() throws OperationNotSupportedException {
        if (this.cursor == 0 && this.storedIntegers[this.cursor] == null) {
            throw new OperationNotSupportedException();
        }

        this.storedIntegers[this.cursor--] = null;
    }

    public Integer[] fetch() {
        return this.storedIntegers;
    }
}
