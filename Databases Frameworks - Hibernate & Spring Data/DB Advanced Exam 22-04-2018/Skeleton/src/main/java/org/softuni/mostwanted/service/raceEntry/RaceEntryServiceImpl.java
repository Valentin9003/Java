package org.softuni.mostwanted.service.raceEntry;

import org.softuni.mostwanted.model.dto.binding.xml.RaceEntriesImportDto;
import org.softuni.mostwanted.model.entity.Car;
import org.softuni.mostwanted.model.entity.Race;
import org.softuni.mostwanted.model.entity.RaceEntry;
import org.softuni.mostwanted.model.entity.Racer;
import org.softuni.mostwanted.parser.interfaces.ModelParser;
import org.softuni.mostwanted.repository.RaceEntryRepository;
import org.softuni.mostwanted.service.car.CarService;
import org.softuni.mostwanted.service.race.RaceService;
import org.softuni.mostwanted.service.racer.RacerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;

@Service
@Transactional
public class RaceEntryServiceImpl implements RaceEntryService {

    private final RaceEntryRepository raceEntryRepository;
    private final ModelParser modelParser;
    private final CarService carService;
    private final RacerService racerService;
    private final RaceService raceService;

    @Autowired
    public RaceEntryServiceImpl(RaceEntryRepository raceEntryRepository,
                                ModelParser modelParser,
                                CarService carService,
                                RacerService racerService,
                                RaceService raceService) {
        this.raceEntryRepository = raceEntryRepository;
        this.modelParser = modelParser;
        this.carService = carService;
        this.racerService = racerService;
        this.raceService = raceService;
    }

    @Override
    public void create(RaceEntriesImportDto dto) {
        Car car = this.carService.findById(dto.getCarId());
        Racer racer = this.racerService.findByName(dto.getRacer());

        if (car == null || racer == null) {
            throw new IllegalArgumentException();
        } else {
            RaceEntry raceEntry = new RaceEntry();
            raceEntry.setCar(car);
            raceEntry.setRacer(racer);
            raceEntry.setFinishTime(dto.getFinishTime());
            raceEntry.setHasFinished(dto.getHasFinished());

            this.raceEntryRepository.save(raceEntry);
        }
    }

    @Override
    public RaceEntry findOneById(Integer id) {
        return this.raceEntryRepository.findOne(id);
    }
}
