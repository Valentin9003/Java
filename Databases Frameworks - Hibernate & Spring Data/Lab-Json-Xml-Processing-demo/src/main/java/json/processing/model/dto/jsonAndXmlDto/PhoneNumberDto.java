package json.processing.model.dto.jsonAndXmlDto;

import com.google.gson.annotations.Expose;

import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;
import java.io.Serializable;

@XmlAccessorType(XmlAccessType.FIELD)
public class PhoneNumberDto implements Serializable {

    @Expose
    @XmlElement
    private String number;

    @Expose
    @XmlTransient // Stop this field from serializing bc have a cicle
    private PersonDto person;

    public PhoneNumberDto() {
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public PersonDto getPerson() {
        return person;
    }

    public void setPerson(PersonDto person) {
        this.person = person;
    }
}
