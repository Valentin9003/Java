package org.softuni.mostwanted.service.town;

import org.softuni.mostwanted.model.dto.binding.json.TownDtoImportJSON;
import org.softuni.mostwanted.model.entity.Town;

public interface TownService {

    void create(TownDtoImportJSON dto);

    Town findByName(String townName);
}
