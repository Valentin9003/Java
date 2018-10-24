package p03_mankind.models;

public class Student extends Human {

    private static final String INVALID_FACULTY_NUMBER = "Invalid faculty number!";

    private String facultyNumber;

    public Student(String firstName, String lastName, String facultyNumber) {
        super(firstName, lastName);
        this.setFacultyNumber(facultyNumber);
    }

    public String getFacultyNumber() {
        return facultyNumber;
    }

    private void setFacultyNumber(String facultyNumber) {
        if (facultyNumber.length() < 5 || facultyNumber.length() > 10) {
            throw new IllegalArgumentException(INVALID_FACULTY_NUMBER);
        }
        this.facultyNumber = facultyNumber;
    }

    @Override
    public String toString() {
        StringBuilder studentStrBuilder = new StringBuilder();
        studentStrBuilder.append(String.format("First Name: %s", this.getFirstName()))
                .append(System.lineSeparator())
                .append(String.format("Last Name: %s", this.getLastName()))
                .append(System.lineSeparator())
                .append(String.format("Faculty number: %s", this.getFacultyNumber()));

        return studentStrBuilder.toString();
    }
}
