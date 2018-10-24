package models.Interfaces;

public interface ITeacher extends IPerson {

    String getEmail();

    void setEmail(String email);

    Double getSalaryPerHour();

    void setSalaryPerHour(Double salaryPerHour);
}
