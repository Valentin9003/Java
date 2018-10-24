package models;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "store_location")
public class StoreLocation {

    private Integer id;
    private String locationName;
    private Set<Sale> sales;

    public StoreLocation() {
    }

    public StoreLocation(String locationName) {
        this.locationName = locationName;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "location_name")
    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    @OneToMany(mappedBy = "storeLocation", cascade = CascadeType.ALL)
    public Set<Sale> getSales() {
        return sales;
    }

    public void setSales(Set<Sale> sales) {
        this.sales = sales;
    }
}
