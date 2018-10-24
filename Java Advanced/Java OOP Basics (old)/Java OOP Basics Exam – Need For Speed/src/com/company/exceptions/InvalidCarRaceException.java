package com.company.exceptions;

public class InvalidCarRaceException extends IllegalArgumentException {

    private static final String DEFAULT_MESSAGE = "Cannot start the race with zero participants.";

    public InvalidCarRaceException() {
        super(DEFAULT_MESSAGE);
    }

    public InvalidCarRaceException(String message) {
        super(message);
    }
}
