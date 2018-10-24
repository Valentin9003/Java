package app.exam.domain.dto.xml;

import app.exam.parser.XMLParser;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.Date;
import java.util.List;

@XmlRootElement(name = "order")
@XmlAccessorType(XmlAccessType.FIELD)
public class OrderXMLImportDTO{

    @XmlElement
    private String customer;

    @XmlElement
    private String employee;

    @XmlElement
    @XmlJavaTypeAdapter(XMLParser.DateTimeAdapter.class)
    private Date date;

    @XmlElement
    private String type;

    @XmlElementWrapper(name = "items")
    @XmlElement(name = "item")
    private List<OrderItemXMLImportDTO> orderItems;

    public OrderXMLImportDTO() {
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String getEmployee() {
        return employee;
    }

    public void setEmployee(String employee) {
        this.employee = employee;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<OrderItemXMLImportDTO> getItems() {
        return orderItems;
    }

    public void setItems(List<OrderItemXMLImportDTO> items) {
        this.orderItems = items;
    }
}
