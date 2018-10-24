package com.company.exceptions;

public class InvalidCarAccelerationException extends IllegalArgumentException {

    private static final String DEFAULT_MESSAGE = "Invalid input for car acceleration. The acceleration can be [0-100000].";

    public InvalidCarAccelerationException() {
        super(DEFAULT_MESSAGE);
    }

    public InvalidCarAccelerationException(String message) {
        super(message);
    }
}
