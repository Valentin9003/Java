package com.company.exceptions;

public class InvalidCarModelException extends IllegalArgumentException {

    private static final String DEFAULT_MESSAGE = "Invalid input for car model. The model cannot be null.";

    public InvalidCarModelException() {
        super(DEFAULT_MESSAGE);
    }

    public InvalidCarModelException(String message) {
        super(message);
    }
}
