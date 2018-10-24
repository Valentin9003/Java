package com.company.exceptions;

public class InvalidCarParkingException extends IllegalArgumentException {

    private static final String DEFAULT_MESSAGE = "The car cannot be park till participate in the race.";

    public InvalidCarParkingException() {
        super(DEFAULT_MESSAGE);
    }

    public InvalidCarParkingException(String message) {
        super(message);
    }
}
