package org.softuni.mostwanted.model.dto.binding.xml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "entry")
@XmlAccessorType(XmlAccessType.FIELD)
public class RaceEntryDtoImportXML {

    @XmlAttribute
    private Integer id;

    public RaceEntryDtoImportXML() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
