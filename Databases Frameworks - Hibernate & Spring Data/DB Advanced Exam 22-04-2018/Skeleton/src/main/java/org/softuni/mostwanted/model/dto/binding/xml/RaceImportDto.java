package org.softuni.mostwanted.model.dto.binding.xml;

import javax.xml.bind.annotation.*;
import java.util.Set;

@XmlRootElement(name = "race")
@XmlAccessorType(XmlAccessType.FIELD)
public class RaceImportDto {

    @XmlElement
    private Integer laps;
    @XmlElement(name = "district-name")
    private String districtName;

    @XmlElementWrapper(name = "entries")
    @XmlElement(name = "entry")
    private Set<RaceEntryDtoImportXML> entries;

    public RaceImportDto() {
    }

    public Integer getLaps() {
        return laps;
    }

    public void setLaps(Integer laps) {
        this.laps = laps;
    }

    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

    public Set<RaceEntryDtoImportXML> getEntries() {
        return entries;
    }

    public void setEntries(Set<RaceEntryDtoImportXML> entries) {
        this.entries = entries;
    }
}
