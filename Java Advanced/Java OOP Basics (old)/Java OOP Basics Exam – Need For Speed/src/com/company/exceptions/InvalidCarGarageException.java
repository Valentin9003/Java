package com.company.exceptions;

public class InvalidCarGarageException extends IllegalArgumentException {

    private static final String DEFAULT_MESSAGE = "You cannot tune cars, when there are NO PARKED cars in the garage.";

    public InvalidCarGarageException() {
        super(DEFAULT_MESSAGE);
    }

    public InvalidCarGarageException(String message) {
        super(message);
    }
}
