package app.retake.controllers;

import app.retake.domain.dto.ProcedureWrapperXMLImportDTO;
import app.retake.domain.dto.VetWrapperXMLImportDTO;
import app.retake.parser.ValidationUtil;
import app.retake.parser.interfaces.Parser;
import app.retake.services.api.ProcedureService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import javax.xml.bind.JAXBException;
import java.io.IOException;

@Controller
public class ProcedureController {

    private final ProcedureService procedureService;
    private final Parser xmlParser;

    public ProcedureController(ProcedureService procedureService,
                               @Qualifier("XMLParser") Parser xmlParser) {
        this.procedureService = procedureService;
        this.xmlParser = xmlParser;
    }

    public String importDataFromXML(String xmlContent){
        StringBuilder sb = new StringBuilder();
        try {
            ProcedureWrapperXMLImportDTO procedureWrapper = xmlParser.read(ProcedureWrapperXMLImportDTO.class, xmlContent);
            procedureWrapper.getProcedures().forEach(procedure -> {
                try {
                    this.procedureService.create(procedure);

                    sb.append("Record successfully imported.")
                            .append(System.lineSeparator());
                } catch (IllegalArgumentException ignored) {

                }
//                sb.append("Error: Invalid data.").append(System.lineSeparator());
            });
        } catch (JAXBException | IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

    public String exportProcedures() throws IOException, JAXBException {
        return this.xmlParser.write(this.procedureService.exportProcedures());
    }
}
