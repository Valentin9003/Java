package com.company.exceptions;

public class InvalidCarUnparkException extends IllegalArgumentException {

    private static final String DEFAULT_MESSAGE = "Cannot find the car with this id in the garage.";

    public InvalidCarUnparkException() {
        super(DEFAULT_MESSAGE);
    }

    public InvalidCarUnparkException(String message) {
        super(message);
    }
}
