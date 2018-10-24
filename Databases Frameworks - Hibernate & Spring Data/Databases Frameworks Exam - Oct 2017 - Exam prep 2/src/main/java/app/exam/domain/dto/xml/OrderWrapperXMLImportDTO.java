package app.exam.domain.dto.xml;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name = "orders")
@XmlAccessorType(XmlAccessType.FIELD)
public class OrderWrapperXMLImportDTO {

    @XmlElement(name = "order")
    private List<OrderXMLImportDTO> orders;

    public OrderWrapperXMLImportDTO() {
    }

    public List<OrderXMLImportDTO> getOrders() {
        return orders;
    }

    public void setOrders(List<OrderXMLImportDTO> orders) {
        this.orders = orders;
    }
}
