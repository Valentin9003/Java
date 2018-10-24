package com.company.exceptions;

public class InvalidCarDurabilityException extends IllegalArgumentException {

    private static final String DEFAULT_MESSAGE = "Invalid input for car durability. The durability can be [0-100000].";

    public InvalidCarDurabilityException() {
        super(DEFAULT_MESSAGE);
    }

    public InvalidCarDurabilityException(String message) {
        super(message);
    }
}
