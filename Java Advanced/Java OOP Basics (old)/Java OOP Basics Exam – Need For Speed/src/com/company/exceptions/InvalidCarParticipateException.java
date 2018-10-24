package com.company.exceptions;

public class InvalidCarParticipateException extends IllegalArgumentException {

    private static final String DEFAULT_MESSAGE = "Invalid car id. The car is parked in the garage.";

    public InvalidCarParticipateException() {
        super(DEFAULT_MESSAGE);
    }

    public InvalidCarParticipateException(String message) {
        super(message);
    }
}
