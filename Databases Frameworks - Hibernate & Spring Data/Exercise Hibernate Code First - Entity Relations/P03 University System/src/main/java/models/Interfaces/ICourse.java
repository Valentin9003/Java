package models.Interfaces;

import java.time.LocalDate;

public interface ICourse {

    Integer getId();

    void setId(Integer id);

    String getName();

    void setName(String name);

    String getDescription();

    void setDescription(String description);

    LocalDate getStartDate();

    void setStartDate(LocalDate startDate);

    LocalDate getEndDate();

    void setEndDate(LocalDate endDate);

    Integer getCredits();

    void setCredits(Integer credits);
}
