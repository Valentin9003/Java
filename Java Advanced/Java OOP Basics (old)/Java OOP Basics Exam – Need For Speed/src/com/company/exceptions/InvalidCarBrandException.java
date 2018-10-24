package com.company.exceptions;

public class InvalidCarBrandException extends IllegalArgumentException {

    private static final String DEFAULT_MESSAGE = "Invalid input for car brand. The brand cannot be null.";

    public InvalidCarBrandException() {
        super(DEFAULT_MESSAGE);
    }

    public InvalidCarBrandException(String message) {
        super(message);
    }
}
