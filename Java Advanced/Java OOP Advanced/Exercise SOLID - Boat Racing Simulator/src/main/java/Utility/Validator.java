package Utility;

public final class Validator {

    private Validator() {
    }

    public static void ValidatePropertyValue(int value, String propertyName) {
        if (value <= 0) {
            throw new IllegalArgumentException(String.format(Constants.INCORRECT_PROPERTY_VALUE_MESSAGE, propertyName));
        }
    }

    public static void ValidateModelLength(String value, int minModelLength) {
        if (value.length() < minModelLength) {
            throw new IllegalArgumentException(String.format(Constants.INCORRECT_MODEL_LENGTH_MESSAGE, minModelLength));
        }
    }
}
