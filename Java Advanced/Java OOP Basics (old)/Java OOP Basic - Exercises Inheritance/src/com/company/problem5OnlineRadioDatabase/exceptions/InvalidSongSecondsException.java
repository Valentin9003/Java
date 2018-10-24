package com.company.problem5OnlineRadioDatabase.exceptions;

public class InvalidSongSecondsException extends InvalidSongLengthException {

    private static final String DEFFAULT_MESSAGE = "Song seconds should be between 0 and 59.";

    public InvalidSongSecondsException() {
        super(DEFFAULT_MESSAGE);
    }

    public InvalidSongSecondsException(String message) {
        super(message);
    }
}
