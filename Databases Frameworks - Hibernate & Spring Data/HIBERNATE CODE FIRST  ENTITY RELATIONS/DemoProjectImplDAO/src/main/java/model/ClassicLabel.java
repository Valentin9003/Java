package model;

import javax.persistence.*;

@Entity
@Table(name = "labels")
public class ClassicLabel {

    private Long id;
    private String name;
    private BasicShampoo basicShampoo;

    public ClassicLabel() {
    }

    public ClassicLabel(String name) {
        this.name = name;
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

    @OneToOne(mappedBy = "label")
    public BasicShampoo getBasicShampoo() {
        return basicShampoo;
    }

    public void setBasicShampoo(BasicShampoo basicShampoo) {
        this.basicShampoo = basicShampoo;
    }
}
