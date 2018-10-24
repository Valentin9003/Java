package org.softuni.mostwanted.service.racer;

import org.softuni.mostwanted.model.dto.binding.json.RacersDtoImportJSON;
import org.softuni.mostwanted.model.entity.Racer;

public interface RacerService {
    void create(RacersDtoImportJSON dto);

    Racer findByName(String racerName);

}
