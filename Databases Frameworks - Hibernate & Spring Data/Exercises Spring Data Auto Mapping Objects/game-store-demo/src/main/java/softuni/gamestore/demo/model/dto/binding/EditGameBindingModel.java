package softuni.gamestore.demo.model.dto.binding;

import java.math.BigDecimal;

public class EditGameBindingModel {

    private Long id;
    private BigDecimal price;
    private Double size;

    public EditGameBindingModel() {
    }

    public EditGameBindingModel(Long id, BigDecimal price, Double size) {
        this.id = id;
        this.price = price;
        this.size = size;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Double getSize() {
        return size;
    }

    public void setSize(Double size) {
        this.size = size;
    }
}
