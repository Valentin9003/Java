package com.company.exceptions;

public class InvalidCarYearException extends IllegalArgumentException {

    private static final String DEFAULT_MESSAGE = "Invalid input for year of production. The year can be [0-100000].";

    public InvalidCarYearException() {
        super(DEFAULT_MESSAGE);
    }

    public InvalidCarYearException(String message) {
        super(message);
    }
}
