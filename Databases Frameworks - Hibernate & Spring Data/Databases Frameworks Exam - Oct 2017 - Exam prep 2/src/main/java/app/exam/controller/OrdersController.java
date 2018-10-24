package app.exam.controller;

import app.exam.domain.dto.json.EmployeeOrdersJSONExportDTO;
import app.exam.domain.dto.xml.OrderWrapperXMLImportDTO;
import app.exam.parser.interfaces.Parser;
import app.exam.service.api.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.text.SimpleDateFormat;

@Controller
public class OrdersController {

    private final OrderService orderService;
    private final Parser xmlParser;
    private final Parser jsonParser;

    @Autowired
    public OrdersController(OrderService orderService,
                            @Qualifier(value = "XMLParser") Parser xmlParser,
                            @Qualifier(value = "JSONParser") Parser jsonParser) {
        this.orderService = orderService;
        this.xmlParser = xmlParser;
        this.jsonParser = jsonParser;
    }

    public String importDataFromXML(String xmlContent) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        StringBuilder sb = new StringBuilder();
        try {
            OrderWrapperXMLImportDTO orderWrraper =
                    this.xmlParser.read(OrderWrapperXMLImportDTO.class, xmlContent);

            orderWrraper.getOrders().forEach(orderDto -> {
                try {
                    this.orderService.create(orderDto);

                    String date = sdf.format(orderDto.getDate());
                    sb.append(String.format("Order for %s on %s added.", orderDto.getCustomer(), date))
                            .append(System.lineSeparator());
                } catch (IllegalArgumentException iae) {
                    sb.append("Error: Invalid data.").append(System.lineSeparator());
                }
            });
        } catch (IOException | JAXBException e) {
            e.printStackTrace();
        }

        return sb.toString();
    }

    public String exportOrdersByEmployeeAndOrderType(String employeeName, String orderType) {
        EmployeeOrdersJSONExportDTO employeeOrdersJSONExportDTO =
                this.orderService.exportOrdersByEmployeeAndOrderType(employeeName, orderType);

        try {
            return this.jsonParser.write(employeeOrdersJSONExportDTO);
        } catch (IOException | JAXBException e) {
            e.printStackTrace();
        }

        return null;
    }
}
