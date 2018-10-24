package com.company.exceptions;

public class InvalidCarException extends IllegalArgumentException {

    private static final String DEFAULT_MESSAGE = "Invalid car data.";

    public InvalidCarException() {
        super(DEFAULT_MESSAGE);
    }

    public InvalidCarException(String message) {
        super(message);
    }
}
