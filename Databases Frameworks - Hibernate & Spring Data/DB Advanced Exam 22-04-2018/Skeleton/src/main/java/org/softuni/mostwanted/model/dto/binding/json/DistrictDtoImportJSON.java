package org.softuni.mostwanted.model.dto.binding.json;

import com.google.gson.annotations.Expose;

public class DistrictDtoImportJSON {

    @Expose
    private String name;
    @Expose
    private String townName;

    public DistrictDtoImportJSON() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTownName() {
        return townName;
    }

    public void setTownName(String townName) {
        this.townName = townName;
    }
}
