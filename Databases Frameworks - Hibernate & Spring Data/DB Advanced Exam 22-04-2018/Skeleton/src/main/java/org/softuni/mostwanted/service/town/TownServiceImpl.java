package org.softuni.mostwanted.service.town;

import org.softuni.mostwanted.model.dto.binding.json.TownDtoImportJSON;
import org.softuni.mostwanted.model.entity.Town;
import org.softuni.mostwanted.parser.interfaces.ModelParser;
import org.softuni.mostwanted.repository.TownRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;


@Service
@Transactional
public class TownServiceImpl implements TownService {

    private final TownRepository townRepository;
    private final ModelParser modelParser;

    @Autowired
    public TownServiceImpl(TownRepository townRepository,
                           ModelParser modelParser) {
        this.townRepository = townRepository;
        this.modelParser = modelParser;
    }


    @Override
    public void create(TownDtoImportJSON dto) {
        Town town = this.townRepository.findByName(dto.getName());

        if (town != null) {
            throw new IllegalArgumentException();
        } else {
            town = this.modelParser.convert(dto, Town.class);
        }

        String debug = "";
        this.townRepository.saveAndFlush(town);
    }

    @Override
    public Town findByName(String townName) {
        return this.townRepository.findByName(townName);
    }
}
