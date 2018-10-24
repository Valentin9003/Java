package org.softuni.mostwanted.service.district;

import org.softuni.mostwanted.model.dto.binding.json.DistrictDtoImportJSON;
import org.softuni.mostwanted.model.entity.District;
import org.softuni.mostwanted.model.entity.Town;
import org.softuni.mostwanted.parser.interfaces.ModelParser;
import org.softuni.mostwanted.repository.DistrictRepository;
import org.softuni.mostwanted.service.town.TownService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class DistrictServiceImpl implements DistrictService {

    private final DistrictRepository districtRepository;
    private final ModelParser modelParser;
    private final TownService townService;

    @Autowired
    public DistrictServiceImpl(DistrictRepository districtRepository,
                               ModelParser modelParser,
                               TownService townService) {
        this.districtRepository = districtRepository;
        this.modelParser = modelParser;
        this.townService = townService;
    }

    @Override
    public String create(DistrictDtoImportJSON dto) {
        District district = this.districtRepository.findByName(dto.getName());

        if (district != null ){
            return "Error: Duplicate Data!";
        }

        district = this.modelParser.convert(dto, District.class);
        Town town = this.townService.findByName(dto.getTownName());
        district.setTown(town);

        this.districtRepository.save(district);
        return String.format("Successfully imported District – %s.", district.getName());
    }
}
