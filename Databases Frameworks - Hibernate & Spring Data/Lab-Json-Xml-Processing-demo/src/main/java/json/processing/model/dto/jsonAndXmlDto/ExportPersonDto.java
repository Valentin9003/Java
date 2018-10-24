package json.processing.model.dto.jsonAndXmlDto;

import com.google.gson.annotations.Expose;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class ExportPersonDto implements Serializable {

    @Expose
    private String firstName;

    @Expose
    private String lastName;

    @Expose
    private AddressDto address;

    @Expose
    private Set<PhoneNumberDto> phoneNumbers;

    public ExportPersonDto() {
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
