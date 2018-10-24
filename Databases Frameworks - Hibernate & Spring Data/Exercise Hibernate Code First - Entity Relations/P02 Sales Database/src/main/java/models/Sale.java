package models;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "sales")
public class Sale {

    private Integer id;
    private Product product;
    private Customer customer;
    private StoreLocation storeLocation;
    private LocalDate date;

    public Sale() {
        this.date = LocalDate.now();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "product_id", referencedColumnName = "id"
            , foreignKey = @ForeignKey(name = "FK_sale_product"))
    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id", referencedColumnName = "id"
            , foreignKey = @ForeignKey(name = "FK_sale_customer"))
    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "location_id", referencedColumnName = "id"
            , foreignKey = @ForeignKey(name = "FK_sale_location"))
    public StoreLocation getStoreLocation() {
        return storeLocation;
    }

    public void setStoreLocation(StoreLocation storeLocation) {
        this.storeLocation = storeLocation;
    }

    @Basic
    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
