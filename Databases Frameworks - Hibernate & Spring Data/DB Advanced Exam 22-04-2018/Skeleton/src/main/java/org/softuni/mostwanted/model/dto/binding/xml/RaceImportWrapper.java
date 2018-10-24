package org.softuni.mostwanted.model.dto.binding.xml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "races")
@XmlAccessorType(XmlAccessType.FIELD)
public class RaceImportWrapper {

    @XmlElement(name = "race")
    List<RaceImportDto> races;

    public RaceImportWrapper() {
    }

    public List<RaceImportDto> getRaces() {
        return races;
    }

    public void setRaces(List<RaceImportDto> races) {
        this.races = races;
    }
}
