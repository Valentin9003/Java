package models.Interfaces;

public interface IStudent extends IPerson {

    Double getAverageGrade();

    void setAverageGrade(Double averageGrade);

    String getAttendance();

    void setAttendance(String attendance);

}
