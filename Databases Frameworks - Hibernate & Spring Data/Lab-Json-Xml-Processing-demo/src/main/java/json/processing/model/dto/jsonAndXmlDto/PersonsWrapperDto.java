package json.processing.model.dto.jsonAndXmlDto;

import json.processing.model.entity.Person;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.List;

@XmlRootElement(name = "persons")
@XmlAccessorType(XmlAccessType.FIELD)
public class PersonsWrapperDto implements Serializable {

    @XmlElement(name = "person")
    private List<PersonDto> personDtos;

    public PersonsWrapperDto() {
    }

    public List<PersonDto> getPersonDtos() {
        return personDtos;
    }

    public void setPersonDtos(List<PersonDto> personDtos) {
        this.personDtos = personDtos;
    }
}
