package json.processing.serialize.exeptions;

public class SerializeExeption extends RuntimeException {

    public SerializeExeption(String message, Throwable cause) {
        super(message, cause);
    }

    public SerializeExeption(String message) {
        super(message);
    }
}
