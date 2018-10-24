package org.softuni.mostwanted.controllers;

import org.softuni.mostwanted.model.dto.binding.json.TownDtoImportJSON;
import org.softuni.mostwanted.parser.ValidationUtil;
import org.softuni.mostwanted.parser.interfaces.Parser;
import org.softuni.mostwanted.service.town.TownService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.Arrays;

@Controller
public class TownController {

    private final TownService townService;
    private final Parser jsonParser;

    public TownController(TownService townService,
                          @Qualifier("JSONParser") Parser jsonParser) {
        this.townService = townService;
        this.jsonParser = jsonParser;
    }

    public String importTownsFromJSON(String jsonContent) {
        StringBuilder sb = new StringBuilder();
        try {
            TownDtoImportJSON[] townDtos = jsonParser.read(TownDtoImportJSON[].class, jsonContent);
            Arrays.stream(townDtos).forEach(t -> {
                if (ValidationUtil.isValid(t)) {
                    try {
                        this.townService.create(t);
                        sb.append(String.format("Successfully imported Town – %s.", t.getName()))
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
