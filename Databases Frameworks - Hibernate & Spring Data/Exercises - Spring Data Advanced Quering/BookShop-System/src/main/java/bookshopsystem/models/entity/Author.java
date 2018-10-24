package bookshopsystem.models.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "authors")
@NamedStoredProcedureQuery(
        name = "usp_get_author_books",
        procedureName = "usp_get_author_books",
        parameters = {
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "f_name", type = String.class),
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "l_name", type = String.class),
                @StoredProcedureParameter(mode = ParameterMode.OUT, name = "books_count", type = Integer.class)
})
public class Author implements Serializable {

    private Long id;
    private String firstName;
    private String lastName;
    private Set<Book> books;
    private String fullName;

    public Author() {
        this.books = new HashSet<>();
    }

    public Author(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "first_name")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(name = "last_name", nullable = false)
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @OneToMany(mappedBy = "author", targetEntity = Book.class, fetch = FetchType.EAGER)
    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }

    @Transient
    public String getFullName() {
        return String.format("%s %s", this.firstName, this.lastName);
    }
}
