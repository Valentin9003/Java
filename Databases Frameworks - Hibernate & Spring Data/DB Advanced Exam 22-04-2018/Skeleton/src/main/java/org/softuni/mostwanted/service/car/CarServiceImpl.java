package org.softuni.mostwanted.service.car;

import org.softuni.mostwanted.model.dto.binding.json.CarDtoImportJSON;
import org.softuni.mostwanted.model.entity.Car;
import org.softuni.mostwanted.model.entity.Racer;
import org.softuni.mostwanted.parser.interfaces.ModelParser;
import org.softuni.mostwanted.repository.CarRepository;
import org.softuni.mostwanted.service.racer.RacerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



@Service
@Transactional
public class CarServiceImpl implements CarService {

    private final CarRepository carRepository;
    private final ModelParser modelParser;
    private final RacerService racerService;

    @Autowired
    public CarServiceImpl(CarRepository carRepository,
                          ModelParser modelParser,
                          RacerService racerService) {
        this.carRepository = carRepository;
        this.modelParser = modelParser;
        this.racerService = racerService;
    }

    @Override
    public void create(CarDtoImportJSON dto) {
        Car car = this.carRepository.findByBrandAndModelAndYearOfProduction(
                dto.getBrand(), dto.getModel(), dto.getYearOfProduction());

        if (car != null) {
// TODO...      throw new IllegalArgumentException();
        } else {
            car = modelParser.convert(dto, Car.class);

            Racer racer = this.racerService.findByName(dto.getRacerName());
            if (racer != null) {
                car.setRacer(racer);
            }
        }
        this.carRepository.save(car);
    }

    @Override
    public Car findById(Integer carId) {
        return this.carRepository.findById(carId);
    }
}
