package app.retake.controllers;

import app.retake.domain.dto.AnimalAidJSONImportDTO;
import app.retake.domain.dto.VetWrapperXMLImportDTO;
import app.retake.parser.ValidationUtil;
import app.retake.parser.interfaces.Parser;
import app.retake.services.api.VetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import javax.xml.bind.JAXBException;
import java.io.IOException;

@Controller
public class VetController {

    private final VetService vetService;
    private final Parser xmlParser;

    @Autowired
    public VetController(VetService vetService,
                         @Qualifier(value = "XMLParser") Parser parser) {
        this.vetService = vetService;
        this.xmlParser = parser;
    }

    public String importDataFromXML(String xmlContent){
        StringBuilder sb = new StringBuilder();
        try {
            VetWrapperXMLImportDTO vetWrapper = xmlParser.read(VetWrapperXMLImportDTO.class, xmlContent);
            vetWrapper.getVets().forEach(v -> {
                if (ValidationUtil.isValid(v)) {
                    this.vetService.create(v);
                    sb.append(String.format("Record %s successfully imported.", v.getName()))
                            .append(System.lineSeparator());
                } else {
                    sb.append("Error: Invalid data.").append(System.lineSeparator());
                }
            });
        } catch (JAXBException | IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }
}
