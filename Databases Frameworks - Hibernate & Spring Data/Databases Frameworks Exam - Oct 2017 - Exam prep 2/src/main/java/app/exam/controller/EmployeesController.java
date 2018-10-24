package app.exam.controller;

import app.exam.domain.dto.json.EmployeeJSONImportDTO;
import app.exam.parser.ValidationUtil;
import app.exam.parser.interfaces.Parser;
import app.exam.service.api.EmployeeService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.Arrays;

@Controller
public class EmployeesController {

    private final Parser jsonParser;
    private final EmployeeService employeeService;

    public EmployeesController(
            @Qualifier(value = "JSONParser") Parser parser,
            EmployeeService employeeService) {
        this.jsonParser = parser;
        this.employeeService = employeeService;
    }

    public String importDataFromJSON(String jsonContent) {
        StringBuilder sb = new StringBuilder();
        try {
            EmployeeJSONImportDTO[] importDTOS = this.jsonParser.read(EmployeeJSONImportDTO[].class, jsonContent);
            Arrays.stream(importDTOS)
                    .forEach(dto -> {
                        if (ValidationUtil.isValid(dto)) {
                            this.employeeService.create(dto);
                            sb.append(String.format("Record %s successfully imported.", dto.getName()))
                                    .append(System.lineSeparator());
                        } else {
                            sb.append("Error: Invalid data.").append(System.lineSeparator());
                        }
                    });

            String debug = "";
        } catch (IOException | JAXBException e) {
            e.printStackTrace();
        }

        return sb.toString();
    }
}
