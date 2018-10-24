package com.company.problem5OnlineRadioDatabase.exceptions;

public class InvalidArtistNameException extends InvalidSongException {

    private static final String DEFFAULT_MESSAGE = "Artist name should be between 3 and 20 symbols.";

    public InvalidArtistNameException() {
        super(DEFFAULT_MESSAGE);
    }

    public InvalidArtistNameException(String message) {
        super(message);
    }
}
