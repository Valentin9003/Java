package org.softuni.mostwanted.controllers;

import org.softuni.mostwanted.model.dto.binding.xml.RaceEntriesImportDto;
import org.softuni.mostwanted.model.dto.binding.xml.RaceEntriesImportWraperDto;
import org.softuni.mostwanted.parser.interfaces.Parser;
import org.softuni.mostwanted.service.raceEntry.RaceEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Controller;

import javax.xml.bind.JAXBException;
import java.io.IOException;

@Controller
public class RaceEntryController {

    private final RaceEntryService raceEntryService;
    private final Parser xmlParser;

    @Autowired
    public RaceEntryController(RaceEntryService raceEntryService,
                               @Qualifier("XMLParser") Parser xmlParser) {
        this.raceEntryService = raceEntryService;
        this.xmlParser = xmlParser;
    }

    public String importDataFromXML(String xmlContent) {
        StringBuilder sb = new StringBuilder();

        try {
            RaceEntriesImportWraperDto entriesImportWrapper = xmlParser.read(RaceEntriesImportWraperDto.class, xmlContent);

            int counter = 0;
            for (RaceEntriesImportDto re : entriesImportWrapper.getRaceEntries()) {
                try {
                    this.raceEntryService.create(re);
                    counter++;
                    sb.append(String.format("Successfully imported RaceEntry - %d", counter));
                    sb.append(System.lineSeparator());
                } catch (IllegalArgumentException ignored) {
                    sb.append("Error: Incorrect Data!").append(System.lineSeparator());
                }
            }
        } catch (JAXBException | IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }
}
