package bookshopsystem.dto;

public class AuthorDto {

    private String firstName;
    private String lastName;
    private Long sumCopies;

    public AuthorDto() {
    }

    public AuthorDto(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public AuthorDto(String firstName, String lastName, Long sumCopies) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.sumCopies = sumCopies;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFullName() {
        return String.format("%s %s", this.firstName, this.lastName);
    }

    public Long getSumCopies() {
        return sumCopies;
    }

    public void setSumCopies(Long sumCopies) {
        this.sumCopies = sumCopies;
    }
}
