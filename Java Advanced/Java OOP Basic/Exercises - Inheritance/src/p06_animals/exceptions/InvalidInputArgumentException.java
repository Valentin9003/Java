package p06_animals.exceptions;

public class InvalidInputArgumentException extends IllegalArgumentException {

    public static final String DEFAULT_EXCEPTION_MESSAGE = "Invalid input!";

    public InvalidInputArgumentException() {
        super(DEFAULT_EXCEPTION_MESSAGE);
    }

    public InvalidInputArgumentException(String message) {
        super(message);
    }
}
