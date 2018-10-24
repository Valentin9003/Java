package org.softuni.mostwanted.controllers;

import org.softuni.mostwanted.model.dto.binding.xml.RaceEntriesImportDto;
import org.softuni.mostwanted.model.dto.binding.xml.RaceEntriesImportWraperDto;
import org.softuni.mostwanted.model.dto.binding.xml.RaceImportDto;
import org.softuni.mostwanted.model.dto.binding.xml.RaceImportWrapper;
import org.softuni.mostwanted.parser.interfaces.Parser;
import org.softuni.mostwanted.service.race.RaceService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import javax.xml.bind.JAXBException;
import java.io.IOException;

@Controller
public class RaceController {

    private final RaceService raceService;
    private final Parser xmlParser;

    public RaceController(RaceService raceService,
                          @Qualifier("XMLParser") Parser xmlParser) {
        this.raceService = raceService;
        this.xmlParser = xmlParser;
    }

    public String importDataFromXML(String xmlContent) {
        StringBuilder sb = new StringBuilder();
        try {
            RaceImportWrapper raceWrapper = xmlParser.read(RaceImportWrapper.class, xmlContent);
            for (RaceImportDto re : raceWrapper.getRaces()) {
                String resultText = this.raceService.create(re);
                sb.append(resultText).append(System.lineSeparator());
            }
        } catch (JAXBException | IOException e) {
            e.printStackTrace();
        }

        return sb.toString();
    }
}
