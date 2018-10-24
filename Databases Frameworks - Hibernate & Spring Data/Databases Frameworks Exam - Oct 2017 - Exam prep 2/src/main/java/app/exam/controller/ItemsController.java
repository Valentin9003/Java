package app.exam.controller;

import app.exam.domain.dto.json.ItemJSONImportDTO;
import app.exam.parser.ValidationUtil;
import app.exam.parser.interfaces.Parser;
import app.exam.service.api.ItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.Arrays;

@Controller
public class ItemsController {

    private final ItemsService itemsService;
    private final Parser jsonParser;

    @Autowired
    public ItemsController(ItemsService itemsService,
                           @Qualifier(value = "JSONParser") Parser jsonParser) {
        this.itemsService = itemsService;
        this.jsonParser = jsonParser;
    }

    public String importDataFromJSON(String jsonContent) {
        StringBuilder sb = new StringBuilder();
        try {
            ItemJSONImportDTO[] importDtos =
                    this.jsonParser.read(ItemJSONImportDTO[].class, jsonContent);

            Arrays.stream(importDtos).forEach(dto -> {
                if (ValidationUtil.isValid(dto)) {
                    try {
                        this.itemsService.create(dto);
                        sb.append(String.format("Record %s successfully imported.", dto.getName()))
                                .append(System.lineSeparator());
                    } catch (IllegalArgumentException ignore) {
                        sb.append("Error: Invalid data.").append(System.lineSeparator());
                    }
                } else {
                    sb.append("Error: Invalid data.").append(System.lineSeparator());
                }
            });
        } catch (IOException | JAXBException e) {
            e.printStackTrace();
        }

        return sb.toString();
    }
}
