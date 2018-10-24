package org.softuni.mostwanted.service.car;

import org.softuni.mostwanted.model.dto.binding.json.CarDtoImportJSON;
import org.softuni.mostwanted.model.entity.Car;

public interface CarService {
    void create(CarDtoImportJSON dto);


    Car findById(Integer carId);
}
