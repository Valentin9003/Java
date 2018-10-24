package com.company.Problem4BeerCounter;

public class BeerCounter {
    static Integer beerInStock = 0;
    static Integer beersDrankCount  = 0;
    private int boughtBeers;
    private int drankBeers;

    public BeerCounter(int boughtBeers, int drankBeers) {
        this.setBoughtBeers(boughtBeers);
        this.setDrankBeers(drankBeers);
        BeerCounter.BuyBeer(boughtBeers);
        BeerCounter.DrinkBeer(drankBeers);
    }

    public void setBoughtBeers(int boughtBeers) {
        this.boughtBeers = boughtBeers;
    }
    public void setDrankBeers(int drankBeers) {
        this.drankBeers = drankBeers;
    }

    private static void BuyBeer(int bottlesCount) {
        beerInStock += bottlesCount;
    }

    private static void DrinkBeer(int bottlesCount) {
        beersDrankCount += bottlesCount;
        beerInStock -= bottlesCount;
    }
}
