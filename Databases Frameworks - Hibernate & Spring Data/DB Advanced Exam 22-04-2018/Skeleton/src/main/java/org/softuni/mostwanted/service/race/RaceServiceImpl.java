package org.softuni.mostwanted.service.race;

import org.softuni.mostwanted.model.dto.binding.xml.RaceImportDto;
import org.softuni.mostwanted.model.entity.District;
import org.softuni.mostwanted.model.entity.Race;
import org.softuni.mostwanted.model.entity.RaceEntry;
import org.softuni.mostwanted.repository.DistrictRepository;
import org.softuni.mostwanted.repository.RaceRepository;
import org.softuni.mostwanted.service.raceEntry.RaceEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.Set;

@Service
@Transactional
public class RaceServiceImpl implements RaceService {

    private final RaceRepository raceRepository;
    private final DistrictRepository districtRepository;
    private final RaceEntryService raceEntryService;

    @Autowired
    public RaceServiceImpl(RaceRepository raceRepository,
                           DistrictRepository districtRepository,
                           RaceEntryService raceEntryService) {
        this.raceRepository = raceRepository;
        this.districtRepository = districtRepository;
        this.raceEntryService = raceEntryService;
    }

    @Override
    public String create(RaceImportDto re) {
        Race race = new Race();

        //TODO...
        District district = this.districtRepository.findByName(re.getDistrictName());

        Set<RaceEntry> raceEntrySet = new HashSet<>();
        re.getEntries().forEach(e -> {
            RaceEntry oneById = this.raceEntryService.findOneById(e.getId());
            if (oneById != null) {
                raceEntrySet.add(oneById);
            }
        });

        race.setLaps(re.getLaps());
        race.setDistrict(district);
        race.setEntries(raceEntrySet);

        this.raceRepository.saveAndFlush(race);

        return String.format("Successfully imported Race - %d", race.getId());
    }
}
