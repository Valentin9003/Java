package com.company.mankind;

public abstract class Human {

    private String firstName;
    private String lastName;

    public Human(String firstName, String lastName) {
        this.setFirstName(firstName);
        this.setLastName(lastName);
    }

    private void setFirstName(String firstName) {
        if (isFirstLetterNotCapital(firstName)) {
            throw new IllegalArgumentException("Expected upper case letter!Argument: firstName");
        } else if (firstName.length() < 4) {
            throw new IllegalArgumentException("Expected length at least 4 symbols!Argument: firstName");
        }
        this.firstName = firstName;
    }

    protected void setLastName(String lastName) {
        if (isFirstLetterNotCapital(lastName)) {
            throw new IllegalArgumentException("Expected upper case letter!Argument: lastName");
        } else if (lastName.length() < 3) {
            throw new IllegalArgumentException("Expected length at least 3 symbols!Argument: lastName ");
        }
        this.lastName = lastName;
    }

    private boolean isFirstLetterNotCapital(String name) {
       if (name.substring(0, 1).equals(name.substring(0, 1).toUpperCase())) {
           return false;
       }
       return true;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
