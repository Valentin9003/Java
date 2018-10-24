package p05_onlineRadioDatabase.exceptions;

public class InvalidSongException extends IllegalArgumentException {

    private static final String DEFAULT_MESSAGE = "Invalid song.";

    public InvalidSongException() {
        super(DEFAULT_MESSAGE);
    }

    public InvalidSongException(String message) {
        super(message);
    }
}
