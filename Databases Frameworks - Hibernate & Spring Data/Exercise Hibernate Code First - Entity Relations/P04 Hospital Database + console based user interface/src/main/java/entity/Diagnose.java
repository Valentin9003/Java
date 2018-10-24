package entity;

import javax.persistence.*;

@Entity
@Table(name = "diagnoses")
public class Diagnose {

    private Long id;
    private String name;
    private String comments;

    public Diagnose() {
    }

    public Diagnose(String name, String comments) {
        this.setName(name);
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
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
}
