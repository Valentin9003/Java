package p03_carShopExtend.models.modelsImpl;

import p03_carShopExtend.models.Rentable;

import java.io.Serializable;

public class Audi extends BaseCar implements Rentable, Serializable {

    private Integer minRentDay;
    private Double pricePerDay;

    public Audi(String model, String color, Integer horsePower, String countryProduced, Integer minRentDay, Double price) {
        super(model, color, horsePower, countryProduced);
        this.minRentDay = minRentDay;
        this.pricePerDay = price;
    }

    @Override
    public Integer getMinRentDay() {
        return this.minRentDay;
    }

    @Override
    public Double getPricePerDay() {
        return this.pricePerDay;
    }
}
