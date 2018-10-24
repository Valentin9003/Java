package softuni.gamestore.demo.model.dto.view;

import java.math.BigDecimal;
import java.util.Date;

public class DetailGameViewModel {

    private String title;
    private BigDecimal price;
    private Double size;
    private String youtobeId;
    private String imageUrl;
    private String description;
    private Date releaseDate;

    public DetailGameViewModel() {
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

    public Double getSize() {
        return size;
    }

    public void setSize(Double size) {
        this.size = size;
    }

    public String getYoutobeId() {
        return youtobeId;
    }

    public void setYoutobeId(String youtobeId) {
        this.youtobeId = youtobeId;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(String.format("Title: %s%n", this.getTitle()))
                .append(String.format("Price: %.2f%n", this.getPrice()))
                .append(String.format("Size: %.1f%n", this.size))
                .append(String.format("Description: %s%n", this.getDescription()))
                .append(String.format("Release date: %s%n", this.getReleaseDate().toString()))
                .append(String.format("YouToBe id: %s%n", this.getYoutobeId()))
                .append(String.format("Image URL: %s%n", this.getImageUrl()));

        return sb.toString();
    }
}
