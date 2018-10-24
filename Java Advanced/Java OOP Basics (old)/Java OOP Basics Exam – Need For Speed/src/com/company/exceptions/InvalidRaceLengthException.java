package com.company.exceptions;

public class InvalidRaceLengthException extends IllegalArgumentException {

    private static final String DEFAULT_MESSAGE = "Invalid input for race length. The length can be [0-100000].";

    public InvalidRaceLengthException() {
        super(DEFAULT_MESSAGE);
    }

    public InvalidRaceLengthException(String message) {
        super(message);
    }
}
