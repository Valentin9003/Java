package json.processing.model.dto.jsonAndXmlDto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.xml.bind.annotation.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

@XmlRootElement(name = "person") // class who will be inport/export need to hava anotation Root
@XmlAccessorType(XmlAccessType.FIELD)
public class PersonDto implements Serializable {

    @Expose // Annotation for json!!!
    @XmlElement(name = "first_name")
    private String firstName;

    @Expose
    @XmlElement(name = "last_name")
    private String lastName;

    @Expose
    @SerializedName(value = "addressImportDto")
    @XmlElement
    private AddressDto address;

    @Expose
    @SerializedName(value = "phoneJsonDtos")
    @XmlElementWrapper(name = "phone_numbers") // Collection tag to be "phone_numbers"
    @XmlElement(name = "phone_number") // Every element in the collection to be with tag "phone_number"
    private Set<PhoneNumberDto> phoneNumbers;

    public PersonDto() {
        phoneNumbers = new HashSet<>();
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

    public AddressDto getAddress() {
        return address;
    }

    public void setAddress(AddressDto address) {
        this.address = address;
    }

    public Set<PhoneNumberDto> getPhoneNumbers() {
        return phoneNumbers;
    }

    public void setPhoneNumbers(Set<PhoneNumberDto> phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }
}
