package p03_mankind.models;

public class Human {

    private static final String INVALID_FORMAT_FIRST_NAME_EX_MSG = "Expected upper case letter!Argument: firstName";
    private static final String INVALID_FIRST_NAME_LENGTH_EX_MSG = "Expected length at least 4 symbols!Argument: firstName";
    private static final String INVALID_FORMAT_LAST_NAME_EX_MSG = "Expected upper case letter!Argument: lastName";
    private static final String INVALID_LAST_NAME_LENGTH_EX_MSG = "Expected length at least 3 symbols!Argument: lastName";
    private static final String REGEX_NAME_START_WITH_SMALL_LETTER = "^[a-z]\\w+$";

    private String firstName;
    private String lastName;

    public Human(String firstName, String lastName) {
        this.setFirstName(firstName);
        this.setLastName(lastName);
    }

    public String getFirstName() {
        return this.firstName;
    }

    protected void setFirstName(String firstName) {
        if (firstName.matches(REGEX_NAME_START_WITH_SMALL_LETTER)) {
            throw new IllegalArgumentException(INVALID_FORMAT_FIRST_NAME_EX_MSG);
        } else if (firstName.length() < 4) {
            throw new IllegalArgumentException(INVALID_FIRST_NAME_LENGTH_EX_MSG);
        }
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    protected void setLastName(String lastName) {
        if (lastName.matches(REGEX_NAME_START_WITH_SMALL_LETTER)) {
            throw new IllegalArgumentException(INVALID_FORMAT_LAST_NAME_EX_MSG);
        } else if (lastName.length() < 3) {
            throw new IllegalArgumentException(INVALID_LAST_NAME_LENGTH_EX_MSG);
        }
        this.lastName = lastName;
    }
}
