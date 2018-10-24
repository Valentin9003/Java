package softuni.gamestore.demo.model.dto.view;

import java.math.BigDecimal;

public class ViewGameViewModel {

    private String title;
    private BigDecimal price;

    public ViewGameViewModel() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
