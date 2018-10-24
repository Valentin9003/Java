package com.company.exceptions;

public class InvalidCarIdException extends IllegalArgumentException {

    private static final String DEFAULT_MESSAGE = "Invalid car id, don't exist car with this id.";

    public InvalidCarIdException() {
        super(DEFAULT_MESSAGE);
    }

    public InvalidCarIdException(String message) {
        super(message);
    }
}
