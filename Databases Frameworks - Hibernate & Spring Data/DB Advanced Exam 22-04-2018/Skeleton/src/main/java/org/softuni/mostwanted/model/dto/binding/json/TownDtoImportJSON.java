package org.softuni.mostwanted.model.dto.binding.json;

import com.google.gson.annotations.Expose;

public class TownDtoImportJSON {

    @Expose
    private String name;

    public TownDtoImportJSON() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
