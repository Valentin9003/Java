package json.processing.model.entity;

import json.processing.model.dto.jsonAndXmlDto.PhoneNumberDto;
import json.processing.validation.ValidatorUtils;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

@Entity
@Table(name = "persons")
public class Person implements Serializable {

    private Long id;
    private String firstName;
    private String lastName;
    private Address address;
    private Set<PhoneNumber> phoneNumbers;

    public Person() {
        phoneNumbers = new HashSet<>();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Length(min = 4, max = 10)
    @Column(name = "first_name")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(name = "last_name")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    public Set<PhoneNumber> getPhoneNumbers() {
        return phoneNumbers;
    }

    public void setPhoneNumbers(Set<PhoneNumber> phoneNumbers) {
//        ValidatorUtils validatorUtils = new ValidatorUtils();
        for (Iterator<PhoneNumber> i = phoneNumbers.iterator(); i.hasNext();) {
            PhoneNumber phoneNumber = i.next();
            if (!phoneNumber.getNumber().matches("[0-9]{8,10}")) {
                i.remove();
            }
//            if (!validatorUtils.isValid(phoneNumber)) {
//                i.remove();
//            }
        }
        this.phoneNumbers = phoneNumbers;
    }
}
