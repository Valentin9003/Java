package com.company.exceptions;

public class InvalidRacePrizePoolException extends IllegalArgumentException {

    private static final String DEFAULT_MESSAGE = "Invalid input for race prize pool. The prize pool can be [0-100000].";

    public InvalidRacePrizePoolException() {
        super(DEFAULT_MESSAGE);
    }

    public InvalidRacePrizePoolException(String message) {
        super(message);
    }
}
