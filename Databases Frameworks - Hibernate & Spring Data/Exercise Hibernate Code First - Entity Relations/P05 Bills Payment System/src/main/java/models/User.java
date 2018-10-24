package models;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private Set<BasicBillingDetail> billingDetails;

    public User() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "first_name", nullable = false)
    public String getFirst_name() {
        return firstName;
    }

    public void setFirst_name(String first_name) {
        this.firstName = first_name;
    }

    @Column(name = "last_name", nullable = false)
    public String getLast_name() {
        return lastName;
    }

    public void setLast_name(String last_name) {
        this.lastName = last_name;
    }

    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name = "password", nullable = false)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @OneToMany(mappedBy = "owner")
    public Set<BasicBillingDetail> getBillingDetails() {
        return billingDetails;
    }

    public void setBillingDetails(Set<BasicBillingDetail> billingDetails) {
        this.billingDetails = billingDetails;
    }
}
