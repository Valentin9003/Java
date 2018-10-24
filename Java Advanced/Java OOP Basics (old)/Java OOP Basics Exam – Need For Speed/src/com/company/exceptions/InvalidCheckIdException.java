package com.company.exceptions;

public class InvalidCheckIdException extends IllegalArgumentException {

    private static final String DEFAULT_MESSAGE = "Database don't contain the car with the given id.";

    public InvalidCheckIdException() {
        super(DEFAULT_MESSAGE);
    }

    public InvalidCheckIdException(String message) {
        super(message);
    }
}
