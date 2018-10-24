package org.softuni.mostwanted.service.raceEntry;

import org.softuni.mostwanted.model.dto.binding.xml.RaceEntriesImportDto;
import org.softuni.mostwanted.model.entity.RaceEntry;

public interface RaceEntryService {

    void create(RaceEntriesImportDto re);

    RaceEntry findOneById(Integer id);
}
