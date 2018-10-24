package org.softuni.mostwanted.model.dto.binding.xml;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name = "race-entries")
@XmlAccessorType(XmlAccessType.FIELD)
public class RaceEntriesImportWraperDto {

    @XmlElement(name = "race-entry")
    List<RaceEntriesImportDto> raceEntries;

    public RaceEntriesImportWraperDto() {
    }

    public List<RaceEntriesImportDto> getRaceEntries() {
        return raceEntries;
    }

    public void setRaceEntries(List<RaceEntriesImportDto> raceEntries) {
        this.raceEntries = raceEntries;
    }
}
