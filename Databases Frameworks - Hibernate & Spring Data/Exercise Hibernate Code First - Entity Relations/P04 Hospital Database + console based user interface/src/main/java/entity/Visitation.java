package entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "visitations")
public class Visitation {

    private Long id;
    private LocalDate date;
    private String comments;

    public Visitation() {
    }

    public Visitation(String comments) {
        this.date = LocalDate.now();
        this.setComments(comments);
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Basic
    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
}
