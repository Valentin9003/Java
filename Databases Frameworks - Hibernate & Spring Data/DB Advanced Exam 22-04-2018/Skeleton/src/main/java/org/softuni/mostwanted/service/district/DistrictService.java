package org.softuni.mostwanted.service.district;

import org.softuni.mostwanted.model.dto.binding.json.DistrictDtoImportJSON;

public interface DistrictService {

    String create(DistrictDtoImportJSON dto);
}
