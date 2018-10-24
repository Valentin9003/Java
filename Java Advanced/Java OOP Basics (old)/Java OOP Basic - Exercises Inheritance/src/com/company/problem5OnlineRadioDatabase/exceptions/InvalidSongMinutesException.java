package com.company.problem5OnlineRadioDatabase.exceptions;

public class InvalidSongMinutesException extends InvalidSongLengthException {

    private static final String DEFFAULT_MESSAGE = "Song minutes should be between 0 and 14";

    public InvalidSongMinutesException() {
        super(DEFFAULT_MESSAGE);
    }

    public InvalidSongMinutesException(String message) {
        super(message);
    }
}
