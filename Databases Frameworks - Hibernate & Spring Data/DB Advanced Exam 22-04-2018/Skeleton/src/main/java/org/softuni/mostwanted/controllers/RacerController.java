package org.softuni.mostwanted.controllers;

import org.softuni.mostwanted.model.dto.binding.json.RacersDtoImportJSON;
import org.softuni.mostwanted.parser.ValidationUtil;
import org.softuni.mostwanted.parser.interfaces.Parser;
import org.softuni.mostwanted.service.racer.RacerService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.Arrays;

@Controller
public class RacerController {

    private final RacerService racerService;
    private final Parser jsonParser;

    public RacerController(RacerService racerService,
                           @Qualifier("JSONParser") Parser jsonParser) {
        this.racerService = racerService;
        this.jsonParser = jsonParser;
    }

    public String importRacersFromJSON(String jsonContent) {
        StringBuilder sb = new StringBuilder();
        try {
            RacersDtoImportJSON[] districtDtos = jsonParser.read(RacersDtoImportJSON[].class, jsonContent);

            Arrays.stream(districtDtos).forEach(r -> {
                if (ValidationUtil.isValid(r)) {
                    try {
                        this.racerService.create(r);
                        sb.append(String.format("Successfully imported Racer – %s.", r.getName()))
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
