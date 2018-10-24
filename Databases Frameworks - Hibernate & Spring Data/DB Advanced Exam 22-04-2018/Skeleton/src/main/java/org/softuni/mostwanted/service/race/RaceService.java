package org.softuni.mostwanted.service.race;

import org.softuni.mostwanted.model.dto.binding.xml.RaceImportDto;
import org.softuni.mostwanted.model.entity.Race;

public interface RaceService {
    String create(RaceImportDto re);
}
