package org.softuni.mostwanted.controllers;

import org.softuni.mostwanted.model.dto.binding.json.DistrictDtoImportJSON;
import org.softuni.mostwanted.parser.ValidationUtil;
import org.softuni.mostwanted.parser.interfaces.Parser;
import org.softuni.mostwanted.service.district.DistrictService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.Arrays;

@Controller
public class DistrictController {

    private final DistrictService districtService;
    private final Parser jsonParser;

    public DistrictController(DistrictService districtService,
                              @Qualifier("JSONParser") Parser jsonParser) {
        this.districtService = districtService;
        this.jsonParser = jsonParser;
    }

    public String importDistrinctsFromJSON(String jsonContent) {
        StringBuilder sb = new StringBuilder();
        try {
            DistrictDtoImportJSON[] districtDtos = jsonParser.read(DistrictDtoImportJSON[].class, jsonContent);

            Arrays.stream(districtDtos).forEach(d -> {
                if (ValidationUtil.isValid(d)) {
                    String resultText = this.districtService.create(d);
                    sb.append(resultText)
                            .append(System.lineSeparator());
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
