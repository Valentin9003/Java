package com.company.exceptions;

public class InvalidCarHorsePowerException extends IllegalArgumentException {

    private static final String DEFAULT_MESSAGE = "Invalid input for car horse power. The power can be [0-100000].";

    public InvalidCarHorsePowerException() {
        super(DEFAULT_MESSAGE);
    }

    public InvalidCarHorsePowerException(String message) {
        super(message);
    }
}
