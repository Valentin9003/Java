package p03_carShopExtend.models;

public interface Rentable extends Car {

    Integer getMinRentDay();

    Double getPricePerDay();

}
