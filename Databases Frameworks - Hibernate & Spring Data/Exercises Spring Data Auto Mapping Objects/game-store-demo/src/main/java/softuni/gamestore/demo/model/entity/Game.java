package softuni.gamestore.demo.model.entity;

import softuni.gamestore.demo.validators.ImageUrl;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "games")
public class Game {

    private Long id;
    private String title;
    private BigDecimal price;
    private Double size;
    private String youtobeId;
    private String imageUrl;
    private String description;
    private Date releaseDate;
    private Set<User> users;

    public Game() {
        this.users = new HashSet<>();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Pattern(regexp = "^[A-Z][a-zA-Z0-9 ]{2,100}$")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Column(name = "youtobe_id")
    @Pattern(regexp = "^https://www\\.youtube\\.com/watch\\?v=[a-zA-Z]{11}$")
    public String getYoutobeId() {
        return youtobeId;
    }

    public void setYoutobeId(String youtobeId) {
        this.youtobeId = youtobeId;
    }

    @Column(name = "image_url")
    @ImageUrl
    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Column(columnDefinition = "DOUBLE(10,1) DEFAULT 0.0")
    public Double getSize() {
        return size;
    }

    public void setSize(Double size) {
        this.size = size;
    }

    @Column(precision = 20, scale = 2)
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Column(columnDefinition = "TEXT")
    @Size(min = 20)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(name = "release_date")
    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    @ManyToMany(mappedBy = "games", cascade = CascadeType.ALL)
    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

}
