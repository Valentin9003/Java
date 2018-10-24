package p03_carShopExtend.models.modelsImpl;


import p03_carShopExtend.models.Sellable;

import java.io.Serializable;

public class Seat extends BaseCar implements Sellable, Serializable {

    private Double price;

    public Seat(String model, String color, Integer horsePower, String countryProduced, Double price) {
        super(model, color, horsePower, countryProduced);
        this.price = price;
    }

    @Override
    public Double getPrice() {
        return this.price;
    }

}
