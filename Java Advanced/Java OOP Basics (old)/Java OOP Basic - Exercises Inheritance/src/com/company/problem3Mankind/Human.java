package com.company.problem3Mankind;

public abstract class Human {
    private String firstName;
    private String lastName;

    public Human(String firstName, String lastName) {
        this.setFirstName(firstName);
        this.setLastName(lastName);
    }

    protected void setFirstName(String firstName) {
        if (isNotFirstLetterUpperCase(firstName)) {
            throw new IllegalArgumentException("Expected upper case letter!Argument: firstName");
        } else if (firstName.length() < 4) {
            throw new IllegalArgumentException("Expected length at least 4 symbols!Argument: firstName");
        }
        this.firstName = firstName;
    }

    protected void setLastName(String lastName) {
        if (isNotFirstLetterUpperCase(lastName)) {
            throw new IllegalArgumentException("Expected upper case letter!Argument: lastName");
        } else if (lastName.length() < 3) {
            throw new IllegalArgumentException("Expected length at least 3 symbols!Argument: lastName");
        }
        this.lastName = lastName;
    }

    protected String getFirstName() {
        return firstName;
    }

    protected String getLastName() {
        return lastName;
    }

    private boolean isNotFirstLetterUpperCase(String name) {
        boolean isNotUpperCase = false;
        String firstLetter = name.substring(0, 1);
        if (!firstLetter.equals(firstLetter.toUpperCase())) {
            isNotUpperCase = true;
        }
        return isNotUpperCase;
    }
}
