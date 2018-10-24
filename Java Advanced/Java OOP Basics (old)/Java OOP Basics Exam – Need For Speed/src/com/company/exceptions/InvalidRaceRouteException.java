package com.company.exceptions;

public class InvalidRaceRouteException extends IllegalArgumentException {

    private static final String DEFAULT_MESSAGE = "Invalid input for race route. The route cannot be null.";

    public InvalidRaceRouteException() {
        super(DEFAULT_MESSAGE);
    }

    public InvalidRaceRouteException(String message) {
        super(message);
    }
}
