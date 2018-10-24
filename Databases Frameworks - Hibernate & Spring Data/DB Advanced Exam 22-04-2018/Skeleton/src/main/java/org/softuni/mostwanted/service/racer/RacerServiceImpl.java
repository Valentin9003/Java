package org.softuni.mostwanted.service.racer;

import org.softuni.mostwanted.model.dto.binding.json.RacersDtoImportJSON;
import org.softuni.mostwanted.model.entity.Racer;
import org.softuni.mostwanted.model.entity.Town;
import org.softuni.mostwanted.parser.interfaces.ModelParser;
import org.softuni.mostwanted.repository.RacerRepository;
import org.softuni.mostwanted.service.town.TownService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;


@Service
@Transactional
public class RacerServiceImpl implements RacerService {

    private final RacerRepository racerRepository;
    private final TownService townService;
    private final ModelParser modelParser;

    @Autowired
    public RacerServiceImpl(RacerRepository racerRepository,
                            TownService townService,
                            ModelParser modelParser) {
        this.racerRepository = racerRepository;
        this.townService = townService;
        this.modelParser = modelParser;
    }

    @Override
    public void create(RacersDtoImportJSON dto) {
        Racer racer = this.racerRepository.findByName(dto.getName());

        if (racer != null ) {
            throw new IllegalArgumentException();
        } else {
            Racer newRacer = this.modelParser.convert(dto, Racer.class);
            Town town = this.townService.findByName(dto.getTownName());
            if (town != null) {
                newRacer.setHomeTown(town);
            }
            this.racerRepository.saveAndFlush(newRacer);
        }

    }

    @Override
    public Racer findByName(String racerName) {
        return this.racerRepository.findByName(racerName);
    }
}
