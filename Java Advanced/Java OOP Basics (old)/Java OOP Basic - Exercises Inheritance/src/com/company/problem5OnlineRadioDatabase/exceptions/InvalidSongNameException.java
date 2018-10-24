package com.company.problem5OnlineRadioDatabase.exceptions;

public class InvalidSongNameException extends InvalidSongException{

    private static final String DEFFAULT_MESSAGE = "Song name should be between 3 and 30 symbols.";

    public InvalidSongNameException() {
        super(DEFFAULT_MESSAGE);
    }

    public InvalidSongNameException(String message) {
        super(message);
    }
}
