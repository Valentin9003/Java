package org.softuni.mostwanted.model.dto.binding.xml;

import org.softuni.mostwanted.model.entity.Car;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "race-entry")
@XmlAccessorType(XmlAccessType.FIELD)
public class RaceEntriesImportDto {

    @XmlAttribute(name = "has-finished")
    private Boolean hasFinished;
    @XmlAttribute(name = "finish-time")
    private Double finishTime;
    @XmlAttribute(name = "car-id")
    private Integer carId;
    @XmlElement
    private String racer;

    public RaceEntriesImportDto() {
    }

    public Boolean getHasFinished() {
        return hasFinished;
    }

    public void setHasFinished(Boolean hasFinished) {
        this.hasFinished = hasFinished;
    }

    public Double getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(Double finishTime) {
        this.finishTime = finishTime;
    }

    public Integer getCarId() {
        return carId;
    }

    public void setCarId(Integer carId) {
        this.carId = carId;
    }

    public String getRacer() {
        return racer;
    }

    public void setRacer(String racer) {
        this.racer = racer;
    }
}
