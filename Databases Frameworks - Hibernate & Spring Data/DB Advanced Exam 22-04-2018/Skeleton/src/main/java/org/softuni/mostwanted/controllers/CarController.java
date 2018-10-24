package org.softuni.mostwanted.controllers;

import org.softuni.mostwanted.model.dto.binding.json.CarDtoImportJSON;
import org.softuni.mostwanted.parser.ValidationUtil;
import org.softuni.mostwanted.parser.interfaces.Parser;
import org.softuni.mostwanted.service.car.CarService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.Arrays;

@Controller
public class CarController {

    private final CarService carService;
    private final Parser jsonParser;

    public CarController(CarService carService,
                         @Qualifier("JSONParser") Parser jsonParser) {
        this.carService = carService;
        this.jsonParser = jsonParser;
    }

    public String importCarsFromJSON(String jsonContent) {
        StringBuilder sb = new StringBuilder();
        try {
            CarDtoImportJSON[] districtDtos = jsonParser.read(CarDtoImportJSON[].class, jsonContent);

            Arrays.stream(districtDtos).forEach(c -> {
                if (ValidationUtil.isValid(c)
                        && (c.getBrand() != null)
                        && (c.getModel() != null)
                        && (c.getYearOfProduction() != null)) {
                    try {
                        this.carService.create(c);
                        sb.append(String.format("Successfully imported Car – %s %s @ %d",
                                c.getBrand(), c.getModel(), c.getYearOfProduction()))
                                .append(System.lineSeparator());
                    } catch (IllegalArgumentException ignored) {
                        sb.append("Error: Duplicate Data!").append(System.lineSeparator());
                    }
                } else {
                    sb.append("Error: Incorrect Data!").append(System.lineSeparator());
                }
            });

        } catch (IOException | JAXBException e) {
            e.printStackTrace();
        }

        return sb.toString();
    }
}
