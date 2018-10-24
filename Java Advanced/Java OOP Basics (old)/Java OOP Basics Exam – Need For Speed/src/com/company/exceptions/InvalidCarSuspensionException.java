package com.company.exceptions;

public class InvalidCarSuspensionException extends IllegalArgumentException {

    private static final String DEFAULT_MESSAGE = "Invalid input for car suspension. The suspension can be [0-100000].";

    public InvalidCarSuspensionException() {
        super(DEFAULT_MESSAGE);
    }

    public InvalidCarSuspensionException(String message) {
        super(message);
    }
}
