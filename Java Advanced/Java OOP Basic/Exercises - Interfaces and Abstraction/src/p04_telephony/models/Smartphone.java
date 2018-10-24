package p04_telephony.models;

public class Smartphone implements Calleble, Browseble {

    private static final String INVALID_URL_EX_MSG = "Invalid URL!";
    private static final String INVALID_PHONE_NUMBER_EX_MSG = "Invalid number!";

    public Smartphone() {
    }

    @Override
    public String visit(String url) {
        if (url.matches(".*\\d.*")) {
            throw new IllegalArgumentException(INVALID_URL_EX_MSG);
        }

        return String.format("Browsing: %s!", url);
    }

    @Override
    public String call(String phoneNumber) {
        if (phoneNumber.matches(".*\\D.*")) {
            throw new IllegalArgumentException(INVALID_PHONE_NUMBER_EX_MSG);
        }

        return String.format("Calling... %s", phoneNumber);
    }
}
